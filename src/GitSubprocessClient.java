public class GitSubprocessClient {
    public String runGitCommand(String gitCommandArgs, String repoPath) {
        String command = String.format("git %s", gitCommandArgs);
        return Subprocess.runCommand(command, repoPath);
    }
}
