#!/bin/bash

input1=$1
input2=$2

if [[ $input1 =~ ['/!@#$ %^&*()_+'] ]] | [[ $input2 =~ ['/!@#$ %^&*()_+'] ]]; then
  echo "One or more strings contains special characters"
elif [ -z "$input1" ] | [ -z "$input2" ]; then
  echo "One or more strings is null"
elif [ "$input1" = "$input2" ]; then
  echo "Strings are equal"
else
  echo "Strings are not equal"
fi