#!/bin/bash

function fibSumAtIndex(){
    local index=$1
    local fib1=0
    local fib2=1
    local fibSum=0
    local i=0
    while [ $i -lt $index ]
    do
        fibSum=$((fib1+fib2))
        fib1=$fib2
        fib2=$fibSum
        i=$((i+1))
    done
    echo $fibSum
}

read -p "Enter the index: " index
echo "The sum of the fibonacci series at index $index is $(fibSumAtIndex $index)"
