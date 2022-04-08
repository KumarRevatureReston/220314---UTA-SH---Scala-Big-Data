# Revature Training 3/29/2022

Project 1,2 and 3
Commands, File Editors, SSH

## Commands contd.

Developers don't use these commands from today much, these are used by system admins normally

Disk Drive vs Hard Disk Drive

## Partitions

Each and every hard disk has been separated and divided into multiple logical containers, these are called *partitions*

We will separate the hard disk into multiple logical containers (partitions), which we will mount independently

* SCSI - Small computer system interface
* ATA - Advanced Technology and Attachments
* SATA - Serial Advanced Technology and Attachments

**Out of Memory Errors** - might happen working with Hadoop and Apache spark either in a VM or natively. Disk and disk partitions are focused on here because we will bifurcate partitions

Note:
(Some of the commands below might not work on WSL)

## Commands Practice

```
# display information about the filesystem (disk space usage)
df


fdisk -l
sudo fdisk -l
sudo parted -l
lsblk
kill -l5 -l
ps
kill 1
cfdisk
cat /proc/mounts
echo "The quick brown fox jumps over the lazy dog" | sed 's/dog/cat'
blkid
sudo lshw -class disk
lsscsi
```

**mdadm**
Manage MD devices aka Linux Software Raid

## vim

"Vi IMproved"

Vim is a text editor built into many linux distros

It's been around for 20 to 30 years
multiple platforms, multiple windows, recording features
primarily used for Linux text editing purposes

Press i to enter insert mode

To Save
Esc to leave insert mode and enter command line mode
:wq then enter

:q! - quit without saving
:wq - save then quit


Garrett demo
h,j,k,l - left up down right
select mode, insert mode, normal mode

Kumar - Vim Cheatsheet uploaded (for the various commands in command mode)

Database Questions (complete after lunch)

1. Where you got it from
2. What are the queries
3. How did you execute the queries
4. How do you interpret the results

Holden
Question about last requirement

**2nd day meeting with Jessie**

*Back to working on the project*

We are limited to 5 minutes, *reherse presentation within the time limit*

Plagarism - tolerance limit 50% or 60% - Kumar

It's eally hard to say if someone copied and pasted it if it's plagarism from that alone, it is done on a case by case basis

10:30 tomorrow QC starts

## Quiz
- 5 to 6 questions on joins that don't count (he selected do not evaluate)
- 40-42 questions
- 90 minutes
- Basic SQL stuff will be covered
- DDL DQL, DML etc.
- 4PM Eastern Time on Friday







