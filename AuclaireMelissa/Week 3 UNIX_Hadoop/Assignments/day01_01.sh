#!/bin/bash

# 1. Swap two numbers without using third variable
a=12
b=8

# swap a and b
a=$((a+b))
b=$((a-b))
a=$((a-b))

echo "a is $a"
echo "b is $b"
