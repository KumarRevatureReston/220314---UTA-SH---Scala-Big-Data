<!-- 1) mkdir: creates new directories for the user.In order to do this you must have write permission in the parent directory of the new directory -->

mkdir folder1


<!-- 2) ls: lists all the contents of the specified directory.It can be used to obtain information on the files and directories within it -->

ls

<!-- 3) cd: used to change from one directory to another -->

cd .. , cd Desktop

<!-- 4) pwd: prints name of the current working directory.The command gives the full pathname of your current directory -->

pwd > /home/jessica

<!-- 5) mv: move or rename files or directories.It is used to change the name of files or directories, or to move them into other directories. mv cannot move directories from one file-system to another, so, if it is necessary to do that, use cp instead -->

mv sample 007 project_folder

<!-- 6) cp: copy files or directories and is used to make copies of the new files and directories. -->

cp text1 project_folder

<!-- 7) rmdir: remove files or directories. rmdir removesnamed empty directories. If you need to delete a non-empty directory rm -r can be used instead -->
rmdir sample (folder)
rm text1 (file)

<!-- 8) find: search for files in a specified directory hierarchy and all its subdirectories -->

find text1

<!-- 9) history: prints recently used commands -->

History

<!--
10) cat: concatenate files and print on the standard output.takes a copy of a file and sends it to the standard output (i.e. to be displayed on your terminal, unless redirected elsewhere), so it is generally used either to read files, or to string together copies of several files, writing the outputto a new file -->
cat file1 file2

<!-- 11) echo: displays the text that the user types.It is generally used in shell programs. -->
echo

<!-- 12) grep: prints lines that matches a pattern.It also searches for lines containing a specified pattern and, by default, writes them to the standard output.  -->
grep

<!-- 13) wc: print the number of newlines, words, and bytes in files.If no filename is given, wc will count thestandard input instead -->
wc file1

<!-- 14) chmod: change file access permissions.It alters the permissions on files and directories using either symbolic or octal numeric codes -->
chmod  xrx

<!-- 15) ps: report a snapshot of the current processes.This information includes the process id, the controlling terminal (if there is one), the cpu time used so far, and the name of the command being run. -->
ps

PID TTY          TIME CMD
  972 tty1     00:00:00 bash
 1196 tty1     00:00:00 ps

<!-- 16) kill: to kill a process using signal mechanism.It requires the process id (PID). This can be found by using ps -->
kill
kill: usage: kill [-s sigspec | -n signum | -sigspec] pid | jobspec
<!-- 17) date: displays the current date and time -->
date
Mon Mar 28 12:40:29 PDT 2022

<!-- 18) diff: finds the differences between two files.The default output will contain lines such as n1 a n2,n3 and n4,n5 c n6,n7 , (where n1 a n2,n3 means that file2has the extra lines n2 to n3 following the line that has the number n1 in file1, and n4,n5 c n6,n7means that lines n4 to n5 in file1 differ from lines n6 to n7 in file2) -->

diff file1 file2

<!-- 19) file: prints the type of file and the category to which its contents belong. -->
file sample
sample: directory

<!-- 20) wc: prints the total number of lines in a file -->
wc

<!-- 21) ftp: file transfer program;used to make connections with another system -->
ftp

<!-- 22) man: displays an online reference manual page -->
man man

<!-- 23) more: scan through a text file page by page.Also,it displays the contents of a file on a terminal one screenful at a time. -->
more

<!-- 24) vim: a programmer???s text editor -->
vim

<!-- 25) sort: sorts lines of text files in alphabetical order.By default, it sorts lines using a character bycharacter comparison, working from left to right, andusing the order of the ASCII character set. -->

<!-- 26) chown:changes the file owner and group -->
chown

<!-- 27) who:shows how many users are logged in -->
who
whoami

<!-- 28) du:estimate file space usage -->
du

<!-- 29) df:report file system disk space usage -->
df
768640

<!-- 30) passwd:update user???s authentication details.Youwill be prompted twice for your new password. Neither password will be displayed on the screen -->
passwd

<!-- 31) compress: compresses a file.It reduces the size of named files, replacing them with files of the same name extended by .Z .The amount of space saved by compression varies. If no saving of space would occur, then the file willnot be altered. -->

compress file1




<!-- SHELL SCRIPTS:
1) Swap two numbers without using third variable
2) Find the sum of first ???N??? numbers in Fibonacci Series
3) Print a given number in reverse order and sum of the individual digits
4) Read two strings and display whether it is equal , not equal, null strings or string with special characters
5) Accept one integer argument and print its multiplication table -->
