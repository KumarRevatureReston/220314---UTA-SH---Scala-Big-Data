#!/bin/bash

# 4) Read two strings and display whether it is equal , not equal, null strings or string with special characters

echo "Enter the first string"
read str1
echo "Enter the second string"
read str2


if [ $str1 = $str2 ]
then
    echo "Strings are equal"
elif [ -z $str1 ]
    then
        echo "String 1 is null"
elif [ -z $str2 ]
    then
        echo "String 2 is null"
elif [[ $str1 =~ [^[:alnum:]] ]]
    then
        echo "String 1 has special characters"
elif [[ $str2 =~ [^[:alnum:]] ]]
    then
        echo "String 2 has special characters"
else
    echo "Strings are not equal"
fi




