# GitHub client.Subprocess Client

## What is this?

This repo contains a collection of classes that will allow for running Git client.Subprocess calls from a Java program.

## Requirements

- Java 8 or higher

## Usage

A GitSubprocessClient object instance can be created like so, where `repoPath` is the path to the target repo's root folder:

```java
client.GitSubprocessClient gitSubprocessClient = new client.GitSubprocessClient(repoPath);
```

An example repo path:

```java
String repoPath = "C:/Users/Alex/Documents/GitRepos/HelloWorld";
client.GitSubprocessClient gitSubprocessClient = new client.GitSubprocessClient(repoPath);
```

You may change the `repoPath` anytime using the setter method.

From here, you can call any of the available methods.
Click [here] for descriptions/examples of the methods in the GitSubprocessClient object.

