#!/bin/bash

echo "hello"

workDir=.
dataDir="$workDir/date"
dateFile="$dataDir/1.txt"
echo $dateFile

#awk -F, '{print  $1}' ./data/1.txt
awk -F, '{print substr($1,-2, length($1))}' ./data/1.txt
