# GitHub Subprocess Client

## What is this?

This repo contains a collection of classes that will allow for running Git Subprocess calls from a Java program.

## Requirements

- Java 8 or higher

## Usage

A GitSubprocssClient object instance can be created like so, where `repoPath` is the path to the target repo's root folder:

```java
GitSubprocessClient gitSubprocessClient = new GitSubprocessClient(repoPath);
```

From here, you can call any of the available methods.
For example, if you wanted to create a commit for a repo, you would call the `gitCommit` method.
The below example will call the `gitCommit` command on a repo:

```java
GitSubprocessClient gitSubprocessClient = new GitSubprocessClient(repoPath);
String commitResponse = gitSubprocessClient.gitCommit("added a println for hello world");
System.out.println(commitResponse);
```

All Git Subprocess Client responses are Strings, and will be the exact output you would normally see from the terminal. 
For that reason, they are a bit tricky to parse, but nothing that can't be done with a little extra code.


