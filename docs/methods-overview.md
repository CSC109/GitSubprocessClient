[Home](./)

# Git Subprocess Client Methods Overview
{:.no_toc}

* auto-gen TOC:
{:toc}

## Create Client Object Instance

```java
GitSubprocessClient gitSubprocessClient = new GitSubprocessClient(repoPath);
```

## String Responses

All GitSubprocessClient responses are Strings, and will be the exact output you would normally see from the terminal. 
For that reason, they are a bit tricky to parse, but nothing that can't be done with a little extra String manipulation code.
String methods `split` and `substring` are your friends!

## Methods

These are literally identical to the Git terminal commands, just being run in a Java program.

### Git Init

```java
String gitInit = gitSubprocessClient.getInit();
```

### Git Remote Add

Remote name and url must be supplied.
Below will add a remote named "origin" with the url "https://github.com/CSC109/GitSubprocessClient.git"

```java
String gitRemoteAdd = gitSubprocessClient.getRemoteAdd("origin", "https://github.com/CSC109/GitSubprocessClient.git");
```

### Git Add File

Stage a changed file -- **git add \<filePath\>** command.
A file path must be supplied.

```java
String gitAddFile = gitSubprocessClient.gitAddFile("GitSubprocessClient.java");
```

### Git Add All

Stage all changed file -- **git add .** command.

```java
String gitAddAll = gitSubprocessClient.gitAddAll();
```

### Git Commit

Create a commit.
A commit message must be supplied.

```java
String commitMessage = "This is a commit message";

String commit = gitSubprocessClient.gitCommit(commitMessage);
```

### Git Push

Push all recent commits to the remote branch.
A branch name must be specified.

```java
String push = gitSubprocessClient.gitPush("master");
```

### Git Status

Gets the status of the repo.

```java
String status = gitSubprocessClient.gitStatus();
```

### Git Log

Equivalent to running a **git log** to get commit information.
The number of commits to log (starting from most recent) must be supplied.

Below will get the most recent 5 commits.

```java
String log = gitSubprocessClient.gitLog(5);
```

### Git Log One Line

Same as Git Log, but will condense the commit output text.
Equivalent to running **git log --oneline**.
The number of commits to log (starting from most recent) must be supplied.

Below will get the most recent 5 commits.

```java
String log = gitSubprocessClient.gitLogOneLine(5);
```

### Git Log All

Get all commit information.

```java
String log = gitSubprocessClient.gitLogAll();
```

### Git Log All One Line

Same as Git Log All, but will condense the commit output text.
Equivalent to running **git log --oneline**.

```java
String log = gitSubprocessClient.gitLogAllOneLine();
```

### Switch Branch

Checkout to a new branch.
Branch name to checkout to must be supplied.

```java
String checkout = gitSubprocessClient.switchBranch("master");
```

### Create Branch (No Checkout)

Creates a branch. Does NOT checkout to branch.
New branch name must be supplied.

```java
String createBranch = gitSubprocessClient.createBranch("new-branch");
```

### Create and Checkout to Branch

Creates a branch and performs a checkout to branch.
This is the **git checkout -b /<branch name/>** command.
New branch name must be supplied.

```java
String createBranch = gitSubprocessClient.createAndSwitchBranch("new-branch");
```

### Delete Branch

Deletes a branch.
Branch name to delete must be supplied.

```java
String deleteBranch = gitSubprocessClient.deleteBranch("new-branch");
```

### List Branches

Lists all branch names in repo.

```java
String branches = gitSubprocessClient.listBranches();
```

### Git Pull

Performs a pull.
Branch name to pull must be supplied.

```java
String pull = gitSubprocessClient.gitPull("master");
```

### Fetch Branch

Performs a fetch on a specific branch.
Branch name to fetch must be supplied.

```java
String fetch = gitSubprocessClient.gitFetch("master");
```

### Fetch All

Performs a general fetch on all branches.

```java
String fetch = gitSubprocessClient.gitFetchAll();
```

### Git Stash

Stashes away all current changes that have not been committed yet.
They will be "removed" temporarily, but can be reapplied later with Git Stash Apply.

```java
String stash = gitSubprocessClient.gitStash();
```

### Git Stash Apply

Applies current stashed changes.

```java
String stashApply = gitSubprocessClient.gitStashApply();
```

### Any Other Git Command

There is a method called `runGitCommand` that can be used as a "catch all" to run any other Git command not already provided by the client.

For example, to run a `git push origin master` using the `runGitCommit` method, it would look like this:

```java
String commit = gitSubprocessClient.runGitCommand("push origin master");
```