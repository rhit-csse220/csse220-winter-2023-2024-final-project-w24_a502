# Using Git for Your Arcade Game Project

For the arcade game project, you will be doing group development.
Therefore, we'll be asking you to use a source control system called
git.  You've already used git to checkout code/homework from the
CSSE220 repo, but for this project you will be managing a repo.


# Step #1: Create an Account and Create/Join Team
[Instructions](https://docs.google.com/document/d/1L9aUwMvniMmx79O7JsLlsOXOur_VRoDLkfEN9qzDcnI/edit)

1. Create a GitHub Account
2. Accept the GitHub classroom assignment
3. Create or join the appropriate Team

# Step #2: Setting Up PATs for Cloning the Repo

[Setup Personal Access Token (PAT) for GitHub](https://docs.google.com/document/d/1HD18gxAwSevFrFW-OOXy_mlbXAxxkphD2Tbz0eKo5Rk/edit?usp=sharing)

You will NOT be able to clone the repo without doing this.


# Step 3: Cloning the Repo and Renaming the Project

** IMPORTANT: One Person Should Clone and Rename BEFORE Anyone else Clones**

** Pick One Person to do this First!**

1. In your browser, at the top of this page, you should find a green 
button you can use to copy the URI of this project to your clipboard.

![Cloning out repo screenshot](https://github.com/RHIT-CSSE/csse220/blob/master/Docs/misc/checkout_repo.png)

2. Open your Eclipse and go to File > Import > Git > Projects from Git
3. Select "Clone URI"
4. It should automatically get filled out for you, but if not, in the 
   URI field paste the URL you took from the website.  Host and
   repository path should get filled out for you.
5. In Authentication, enter your GITHUB username and INSTEAD of your password you will want to paste in your PAT
from Step #2 (you might find it convenient to have it save these for you, checking the box giving that option) and hit Next
6. In branch selection make sure master is checked and click next
7. In local destination, you can configure anywhere you like *except*
   the directories that your existing CSSE220 repos are being checked
   out to
8. Select "Import existing eclipse projects" and select next.
9. You should see "ArcadeGameGit-00" on the list, make sure it's checked
   and select next
10. You should see a folder for ArcadeGameGit-00 in your project browser

11.  In eclipse, rename your project to have your team name instead of ArcadeGameGit-00.
    Right Click on ArcadeGameGit-00 then Refactor->Rename:

![Renaming repo step 1 screenshot](https://github.com/RHIT-CSSE/csse220/blob/master/Docs/misc/RenameProjectRefactoringStep1.png)

![Renaming repo step 2 screenshot](https://github.com/RHIT-CSSE/csse220/blob/master/Docs/misc/RenameProjectRefactoringStep2.png)

12.  Right click on the project folder and select Team > Commit
13.  Verify that .project appears in your list of "Staged Changes"
14.  Add some text in the commit message "renaming project"
15.  Select Commit and push


# Step 4: Everyone Clone the Repo

All other team members should repeat step #3 except they should get the project
imported from GitHub with the correct name. If for some reason you did not follow
these instructions and multiple people clone the repo before renaming the project, then you will have to
each individually rename the project to see it listed properly. (Pulling will not update it) 
(This is an Eclipse configuration issue where once the project is imported you have to rename it manually).


# Step 5: Test Commit and Push

1. Make a small change to one file (Add a second print statement to MainApp.java).
2. Right click on the project folder and select Team > Commit
3. Verify that file appears in your list of "Staged Changes"
4. Add some text in the commit message "added print statement"
5. Select Commit and push

# Step 6: Test Pull

1. Have *everyone else* on your team pull the latest version
2. Right click on the project folder and select Team > Pull
3. You might have to enter your GITHUB username and PAT (Step #2 above) in the password field (check the box to save it).
4. You should get the updated files

# Step 7: Cause a Merge Conflict

Have *everyone* in your team

1. Edit the same line of code in a different way.  Say add your name
   to the println.
2. Attempt to commit and push.
3. The first person who does it should succeed.  The rest should get
   a "rejected non-fast-forward" error.

For one of those those who failed: 

1. Right click on the project folder and select team > Pull
2. You should see a message about conflict and things will look sort
   of scary
3. Look at the edited file.  You should see that both versions of the
   code are there plus some <<<<< ===== >>>> lines
4. Figure out what the *combination* of the changes ought to be
   (probably all your names in the println) and edit the file to be
   correct, deleting all unnecessary stuff
5. Test your code and make sure that everything works as expected
6. Right click on the project folder and select Team > Commit
7. Manually move all your files into "Staged changes" with the +
8. Commit and push
9. Now have the original committer pull and they should have the
    merged version too
10. If they are any other members of year team, have them do step 4
    onward
    
# Step 8: Let's do this

You have the basics!

0. Do this only if you already have some version of coding running.
1. Have the team member who has the latest version of your source code
   copy all the files into ArcadeGameGit-**
   (hint: you can select files in the eclipse package explored and use
   right click copy and paste)
2. Test and verify that the game runs in its new project
3. Stage all the files, and then commit and push them
4. Have everyone else pull the changes
5. Verify that everyone has a running up to date game on their eclipse

Done!

# Good Advice for Minimizing Merge Conflicts

* [Pair program whenever possible](https://rose-hulman.hosted.panopto.com/Panopto/Pages/Viewer.aspx?id=ddab27fc-a8a4-4cd0-a8f8-abaf013a3f22)
* Always do a Team Pull before you begin programming
* Always to a Team Commit, then Pull, then Push when you finish
* In Eclipse: Right Click -> Replace With -> HEAD Revision is a nice way to remove 
  your local changes before doing a Team->Pull if you don't care about
  the local version of your code and just want to get your partner's version
* If you do have to resolve a merge conflict, remember you must
  accommodate *both* changes 

# Git bash (Command Line)

* A more advanced and full feature program can be used to use [Git for Windows](https://gitforwindows.org/)
* MacOS and Linux have terminal/consoles that can interact with git natively
* There might be times when using these tools will be easier than Eclipse alone
* You are welcome to install it, but in most cases it should not be required
* More about git: [git-handbook](https://guides.github.com/introduction/git-handbook/)

# GitHub Desktop (GUI Application)
* A more intuitive interface than Eclipse and does not require command line familiarity
* Download here [https://desktop.github.com/](https://desktop.github.com/)
