

# Managing the repo via a local repo

## Requirements

1.  Install git on your system.
    - MacOS: `brew install git`
    - Windows: `choco install git` or `https://git-scm.com/download/win`
    - Linux: Installed by default.

NOTE: There is a GUI version of git, but you WILL run into problems using GUI git at some point and going to the terminal will be required.  Also, as a developer, you will be expected to have a basic 
understanding of git commands and how it works. Git is very complex, but there are really only a few commands you need to know.


#### Context  
Git follows a repetitive flow, ask yourself:  
Do I have the repo on my computer? If no then clone it.  
Have I made a change to a file or folder? If yes then commit it.  
Does remote repository(Github) have my changes? If no, then push it.  
Do I have the remote repositorys changes? If no, then pull it.  
Am I on the right branch or commit? If no then check it out.  
Rinse and repeat.

## Fist-time setup:

1. First you want to pull down the folder to your local machine. Open the folder you want to create the repo inside of with your terminal, then run in the terminal:  
    git clone https://github.com/KumarRevatureReston/220314---UTA-SH---Scala-Big-Data.git

A new folder should be created.  

2. Create a local branch.  This branch will be where you make all your incremental/developmental changes.  
    git branch local  
To checkout your branch, type:  
    git checkout local  

3. Now, you can make any changes to the repo that you need to such as adding your files.  For the first time, you probably want to copy the `Example` folder and rename it to your name.  Then, add your files 
to the respective folder.  You can do this with your file explorer or any other method you prefer.  

4. Once you've made your changes you need to commit them.   
    git add .  
    git commit -m "I have successfully made my fist commit via the terminal! :)"  

Your files should now be added to your local repository.  You can now access this point in time of your repo from anywhere in the future!  

5. Now that you have saved your changes to your local branch, you want to save them to the main branch and push it to Github, think of it as submitting the final draft.  
    git checkout main
    git merge local
    git push origin main

You will be prompted to login to your github account.  

## Continued management

At this point, you will just be repeating the same thing over and over again.

1. Get on the right branch:  
    git checkout local

2. Add your changes.  
    git add .

3. Commit your changes.  
    git commit -m "What did I change? Put a brief description here"

4. Get on the right branch:  
    git checkout main

5. Push your changes
    git push origin main

That's it, you know basic git! Now you can manage repos on remote servers where a GUI is not an option. 

## Other cool things

You can create a .gitignore 

The .gitignore file will take RegEx expressions line by line and ignore(untrack) any changes made to files/folders which match the RegEx expression.  
This is useful for password files or notes you may want to store in your local repository but you don't want to push to Github.  

Ex:  
Inside .gitignore:  
\*note.md  

The above line if placed inside the .gitignore file will ignore any file with `note.md` inside it's name within the repo.  Meaning, you don't have to worry about accidently pushing it to Github.  


### Cheatsheet

`git branch` -- Prints out a list of available branchs.  
`git branch local` -- Creates a branch called `local`.  You can name them whatever and have as many branchs as you want.  
`git checkout main` -- Checks out the current commit(HEAD) of branch main.  
    - EX: `git checkout <commit Num/branch>` -- You can checkout a commit via the branch name or the commit number.  To see commit numbers type, `git log`  
`git add .` -- Stages all the changes made within the current directory.  
`git commit -m "my message"` -- Permanently save your changes w/ a message describing what you did.  
`git merge local` -- Merges the changes from the local branch to the current branch.  
    - EX:`git merge main` -- To move main branch changes to your local branch.  
`git pull origin main` -- Pulls down the most recent commit from the main branch on the remote repository(Github).  
`git push origin main` -- Pushes your changes to the remote repository(Github). Note: you will have to commit your changes before you can push.   







