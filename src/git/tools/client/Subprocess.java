package git.tools.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Subprocess {

    public static String runCommand(String command) {
        return runCommand(command, ".");
    }

    public static String runCommand(String command, String workingDirectory) {
        Process process = null;

        try {
            ArrayList<String> commandParts = new ArrayList<>();
            Matcher m = Pattern.compile("([^\"]\\S*|\".+?\")\\s*").matcher(command);
            while (m.find()) {
                commandParts.add(m.group(1));
            }

            process = new ProcessBuilder()
                    .directory(new File(workingDirectory))
                    .command(commandParts)
                    .start();

            process.waitFor(); // wait for subprocess command to finish before moving on
            String output = extractOutput(process);
            String error = extractError(process);
            process.destroy();
            return (output + "\n" + error).trim();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Failed to run command " + command + ": " + e.getMessage());
        }
    }

    private static String extractOutput(Process process) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = null;
        StringBuilder builder = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            builder.append(line);
            builder.append(System.getProperty("line.separator"));
        }
        return builder.toString();
    }

    private static String extractError(Process process) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        String line = null;
        StringBuilder builder = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            builder.append(line);
            builder.append(System.getProperty("line.separator"));
        }
        return builder.toString();
    }
}
