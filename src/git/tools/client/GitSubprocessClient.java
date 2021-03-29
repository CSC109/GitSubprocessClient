package git.tools.client;

public class GitSubprocessClient {

    private String repoPath;

    public GitSubprocessClient(String repoPath) {
        this.repoPath = repoPath;
    }

    public String getRepoPath() {
        return repoPath;
    }

    public void setRepoPath(String repoPath) {
        this.repoPath = repoPath;
    }

    // generic catch all "run git command" for everything else not listed here
    public String runGitCommand(String gitCommandArgs) {
        String command = String.format("git %s", gitCommandArgs);
        return Subprocess.runCommand(command, repoPath);
    }

    public String gitInit() {
        String command = "git init";
        return Subprocess.runCommand(command, repoPath);
    }

    public String gitRemoteAdd(String remoteName, String url) {
        String command = String.format("git remote add %s %s", remoteName, url);
        return Subprocess.runCommand(command, repoPath);
    }

    public String gitAddFile(String filePath) {
        String command = String.format("git add %s", filePath);
        return Subprocess.runCommand(command, repoPath);
    }

    public String gitAddAll() {
        String command = "git add .";
        return Subprocess.runCommand(command, repoPath);
    }

    public String gitCommit(String message) {
        String command = String.format("git commit -m %s", message);
        return Subprocess.runCommand(command, repoPath);
    }

    public String gitPush(String branch) {
        String command = String.format("git push origin %s", branch);
        return Subprocess.runCommand(command, repoPath);
    }

    public String gitStatus() {
        String command = "git status";
        return Subprocess.runCommand(command, repoPath);
    }

    public String gitLog(int numberOfCommits) {
        String command = String.format("git log -%s", numberOfCommits);
        return Subprocess.runCommand(command, repoPath);
    }

    public String gitLogOneLine(int numberOfCommits) {
        String command = String.format("git log --oneline -%s", numberOfCommits);
        return Subprocess.runCommand(command, repoPath);
    }

    public String gitLogAll() {
        String command = "git log";
        return Subprocess.runCommand(command, repoPath);
    }

    public String gitLogAllOneLine() {
        String command = "git log --oneline";
        return Subprocess.runCommand(command, repoPath);
    }

    public String switchBranch(String branch) {
        String command = String.format("git checkout %s", branch);
        return Subprocess.runCommand(command, repoPath);
    }

    public String createBranch(String branch) {
        String command = String.format("git branch %s", branch);
        return Subprocess.runCommand(command, repoPath);
    }

    public String createAndSwitchBranch(String branch) {
        String command = String.format("git checkout -b %s", branch);
        return Subprocess.runCommand(command, repoPath);
    }

    public String deleteBranch(String branch) {
        String command = String.format("git branch -D %s", branch);
        return Subprocess.runCommand(command, repoPath);
    }

    public String listBranches() {
        String command = "git branch --list";
        return Subprocess.runCommand(command, repoPath);
    }

    public String gitPull(String branch) {
        String command = String.format("git pull origin %s", branch);
        return Subprocess.runCommand(command, repoPath);
    }

    public String gitFetchBranch(String branch) {
        String command = String.format("git fetch origin %s", branch);
        return Subprocess.runCommand(command, repoPath);
    }

    public String gitFetchAll() {
        String command = "git fetch";
        return Subprocess.runCommand(command, repoPath);
    }

    public String gitStash() {
        String command = "git stash";
        return Subprocess.runCommand(command, repoPath);
    }

    public String gitStashApply() {
        String command = "git stash apply";
        return Subprocess.runCommand(command, repoPath);
    }
}
