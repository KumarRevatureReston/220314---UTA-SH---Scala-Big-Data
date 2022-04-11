#!/bin/bash

n=$1
ncopy=$1

sd=0
rev=0
while [ $n -gt 0 ]
do
  sd=$(( $n % 10 ))
  rev=$(( $rev * 10 + $sd ))
  n=$(( $n / 10 ))
done

sum=0
while [ $ncopy -gt 0 ]
do
  mod=$((ncopy % 10))
  sum=$((sum + mod))
  ncopy=$((ncopy / 10))
done

echo "Reverse of number: $rev"
echo "Sum of number: $sum"