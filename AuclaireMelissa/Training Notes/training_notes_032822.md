# Revature Training 3/28/2022

## Unix / Hadoop Fundamentals

## Open Source / OSS

Open Source - open source means that the source code is free and open to the public

A developer or user can inspect, modify, distribute code

## OSS vs. Proprietary/Closed

Linux OS was developed by Linus Torvalds in 1991 and sprouted as an idea to improve the UNIX OS.

**License Types**
* MIT License - most people doing training and development or prototype use this
* GPL
* Apache License


**OSS Notes**

- NO warranty for OSS, yes in proprietary (Melissa's Note: some companies may provide their own warranty and support)

- Even though you can modify it you must play by the rules (in the license)

- Basically everything common today uses open source software

- Most people prefer the security of open source software

## Operating System

OS is a bridging between the hardware and the user. The OS enables communication between computer hardware and software

## Linux

Linux is an open source operating system like Windows, Mac OS, iOS, and Android

**Kernel** - core set of functions necessary for the operating system to function, manages system resources, handles communications with hardware, manages entire system resources, manages the communication between hardware in the application

Linux has ~500 distros in active development, ~100 outdated

Examples: Debian, Gentoo, Ubuntu, OpenSuse, RedHat, Kali, Linux Mint

Data people prefer Ubuntu, then Debian, then OpenSuse in that order

Ubuntu is the best for all data scientists, machine learning, data analysts and it's the most widely used on public clouds

Cannonical created Ubuntu and then it was open sourced circa 2004 (~90% of data engineers use Ubuntu)

**SRD - Software Requirement Document**

Outlines the functional and non-functional requirements for a piece of software, as well as the build methodology, project burndown rate and so forth

**Ubuntu** - Ubuntu is an African word meaning "humanity to others", and that all actions have an impact on others (I am what I am because of who we all are, humanity and compassion)

Ubuntu - circle of friends symbol, word mark

**LTS - Long term support**
Ubuntu has a culture where the Ubuntu LTS generally gets released every six months by Cannonical / FSF - Free Software Foundation

## Commands Practice

```
# list files
ls

# list subdirectories recursively (case sensitive)
ls -R

# list files with detailed permissions
ls -r X (X is the case sensitive dirname)
ls -al (list all files with permissions in list format)
ls -a (list all)
```

(Melissa's Note: > means output to file overwriting contents, >> means append to end of file)

`cat >sample007`
This is big data

`car >sample008`
reston

```
cat sample008
cat sample007 sample008
# remove sample007
rm sample007
ls
```

`mv sample008 home/bharath/documents`

```
#change pw
sudo passwd root
```

Kumar posted a Linux commands cheatsheet

Memorize the 15-20 commands in Revature Pro and you should be good

There are commands are for hardware informaiton, performance management, statistics, networking, login, disk usage

```
## make directory
mkdir /tmp/MUSIC
mkdir dir1 dir2 dir3
ls
## remove directory
rmdir dir2
ls
## move directory from location a to b
mv dir1 newdirectoryname
ls
# open the manual page on the manual command
man
man man
```

Garrett
```
cht.sh
ip -br a
# e.g. curl cheat.sh/scala/map
```

```
/bin/echo --help
history
pr -x dir3
```

dll and exe are the same

```
# get weather in Seattle
curl wttr.in/Seattle
```

Melissa
.dll, .exe, .com files

```
# apt - advanced package tool (aptitude)
sudo apt-get upgrade # update install packages
sudo apt-get install mailutils # install mailutils
```

```
history | grep command
```

(Melissa's note: You can execute any command in history by typing ! and then the number of the command)

`!564`


QC - audit for project0 is tomorrow





