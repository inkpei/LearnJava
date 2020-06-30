# docker 备忘录

[docker format 使用](https://www.jianshu.com/p/65377285662e)

## ubuntu 国内源

### 模板

```bash
cp /etc/apt/sources.list /etc/apt/sources.list.bak
echo "" > /etc/apt/sources.list
echo "deb http://mirrors.tuna.tsinghua.edu.cn/ubuntu/ focal main restricted" >> /etc/apt/sources.list
echo "deb http://mirrors.tuna.tsinghua.edu.cn/ubuntu/ focal-updates main restricted" >> /etc/apt/sources.list
echo "deb http://mirrors.tuna.tsinghua.edu.cn/ubuntu/ focal universe" >> /etc/apt/sources.list
echo "deb http://mirrors.tuna.tsinghua.edu.cn/ubuntu/ focal-updates universe" >> /etc/apt/sources.list
echo "deb http://mirrors.tuna.tsinghua.edu.cn/ubuntu/ focal multiverse" >> /etc/apt/sources.list
echo "deb http://mirrors.tuna.tsinghua.edu.cn/ubuntu/ focal-updates multiverse" >> /etc/apt/sources.list
echo "deb http://mirrors.tuna.tsinghua.edu.cn/ubuntu/ focal-backports main restricted universe multiverse" >> /etc/apt/sources.list
echo "deb http://mirrors.tuna.tsinghua.edu.cn/ubuntu/ focal-security main restricted" >> /etc/apt/sources.list
echo "deb http://mirrors.tuna.tsinghua.edu.cn/ubuntu/ focal-security universe" >> /etc/apt/sources.list
echo "deb http://mirrors.tuna.tsinghua.edu.cn/ubuntu/ focal-security multiverse" >> /etc/apt/sources.list
apt-get clean
apt-get update
```

将 `http://mirrors.tuna.tsinghua.edu.cn` 替换为自己喜欢的源即可

```bash
# 阿里云
http://mirrors.aliyun.com
#163
http://mirrors.163.com
```

## docker 容器替换国内源

```bash
cp /etc/apt/sources.list /etc/apt/sources.list.bak
echo "" >  /etc/apt/sources.list
echo "deb http://mirrors.163.com/debian/ jessie main non-free contrib" >> /etc/apt/sources.list
echo "deb http://mirrors.163.com/debian/ jessie-proposed-updates main non-free contrib" >>/etc/apt/sources.list
echo "deb-src http://mirrors.163.com/debian/ jessie main non-free contrib" >>/etc/apt/sources.list
echo "deb-src http://mirrors.163.com/debian/ jessie-proposed-updates main non-free contrib" >>/etc/apt/sources.list
apt-get update
```


## docker 国内源

