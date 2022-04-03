#!/bin/bash

# print a give number in reverse order 

echo "Enter a number"
read num
num=$(echo $num | rev)

echo "Reversed number:  ${num}"


temp=$(echo $num | sed 's/[0-9]/&+/g')
declare -i sum=$(echo $temp | sed 's/+$//') 


echo "Sum of all the numbers: $sum"



