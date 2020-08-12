#!/bin/bash
workDir=.
resultDir=$workDir/data/
rawData=$workDir/1.txt
totalLines=`wc -l $rawData|cut -d " " -f1`
logCount=$workDie"log"
thread=10
#排序
#sort -t ',' -k2 1.txt >/dev/null 2>&1
#echo "排序完成"
date
#检查目录
if [[ ! -d $resultDir ]]
then
	`mkdir $resultDir`
fi
#设置步长，向上取整
function ceil(){
	echo $1 | awk '{print int($1)==$1?int($1):int(int($1)+1)}'
}
stepp=`awk 'BEGIN{ printf "%.5f\n", '$totalLines'/'$thread'}'`
step=`ceil $stepp`
echo "stepp="$stepp
echo "totalLines="$totalLines
echo "step="$step
for((i=0;i<10;i++))
do
{
	#step为每个线程负责的行数，第i个线程处理第i*step+1到第(i+1)*step行
	let s=step*i
	let e=s+step
	#设置每个线程的工作目录dir[i]
	dir=$resultDir"dir"$i"/"
	log=$dir"log"

	echo "线程"$i"启动"":start = "$s";end = "$e

	#根据线程自己的log,判断是否续传
	if [[ -s "$log" ]]
	then
		line=`tail -n 1 $log`
		if [[ $line =~ [1-9][0-9]*$ ]]
		then
			line=`expr $line + 1`
			echo "线程"$i":从第"`expr $line`"行续传"
		else
			echo "线程"$i"log not number"
		fi
	else
		line="1"
		echo "线程"$i"新任务启动"
	fi

	if [[ ! -d $dir ]]
	then
		`mkdir $dir`
	fi
	awk -F , 'BEGIN{start= "'$s'";end="'$e'"} NR > start && NR <= end {
		print $0 >> "'$dir'"substr($2,length($2)-1);
		print NR >> "'$log'";
		print NR
	} END{print "'END'"'$i'}' 1.txt
}&
done
wait
date
