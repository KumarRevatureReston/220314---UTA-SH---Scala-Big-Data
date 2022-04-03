#!/bin/bash


# 5) Accept one integer argument and print its multiplication table

if [ $# -eq 1 ]
then
    for (( i=1; i<=10; i++ ))
    do
        echo "$1 * $i = `expr $1 \* $i`"
    done
else
    echo "Invalid number of arguments"
fi





