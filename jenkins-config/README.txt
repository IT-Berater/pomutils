This pom merge driver for git solves the problem that pull requests in bitbucket fail because it always gives errors when merging the poms.

This driver allows to select which side of the merge for a pom gets the preference.
The default behavior of this driver is to define preferences for merging the project versions. After this merge, it will do a git merge, also mergin dependencies etc.
At dkv we use automatic dependency updates, depending on the branch you're on (develop = latest dev snepshots, release = latest release versions).
We do not want to overwrite these dependency version either, which is what is done by the normal git merge, and this will also give pom merge errors.
So, an extra parameter was added (skipGit) which allows you to only perform the project version merge, and skip the actual git merge. No more pom merge errors.

Downside: if you added dependencies in your source branch, they will not be added to the target branch. You need to do this manually.

This merge driver needs to run on the bitbucket server, as it's there that the automatic merge is executed.

Steps to install this merge driver on bitbucket server:

****************************************************************
* 1) copy the buildtools dir
****************************************************************

Copy the included dir
	bitbucket-mergetools

To:
	C:\Tools\bitbucket-mergetools

On the target machine

****************************************************************
* 2) copy the .gitconfig file to the user dir
****************************************************************

Each user has it's own .gitconfig file in his user dir.
Search which user the bitbucket service is running with.
You need to put the file in his user directory.

Copy the included file 
	.gitconfig
	
To:
	C:\Users\atlbitbucket
	
	
****************************************************************
* 3) try a pull request to see if it works	
****************************************************************

Try a pull request to see if it works.