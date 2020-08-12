#!/bin/bash

echo "hello"

workDir=.
dataDir="./date/"
dateFile="$dataDir1.txt"
line=100

#awk -F, '{print  $1}' ./data/1.txt
#awk -F, 'NR>=100 {print $0}' $dateFile
awk -F , 'BEGIN{x="'$line'" + 1}
          NR==x;
          {
            print $0 >> "'$dataDir'"substr($2,length($2)-1)".txt";
            print NR;
            print $0;
            x=x+1;
          };
          END{print "end"}' ./data/1.txt
