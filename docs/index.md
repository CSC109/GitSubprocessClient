# GitHub Subprocess Client

## What is this?

This packages allows for running Git subprocess calls from a Java program.

## Requirements

- Java 8 or higher

## Usage

A GitSubprocessClient object instance can be created like so, where `repoPath` is the path to the target repo's root folder:

```java
GitSubprocessClient gitSubprocessClient = new GitSubprocessClient(repoPath);
```

An example repo path:

```java
String repoPath = "C:/Users/Alex/Documents/GitRepos/HelloWorld";
GitSubprocessClient gitSubprocessClient = new GitSubprocessClient(repoPath);
```

You may change the `repoPath` anytime using the setter method.

Required import:

```java
import git.tools.client.GitSubprocessClient;
```

You can then call any of the available methods exposed by the `GitSubprocessClient` object.
Click [here](./methods-overview) for descriptions/examples of these methods.

