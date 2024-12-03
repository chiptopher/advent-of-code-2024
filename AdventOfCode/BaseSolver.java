package AdventOfCode;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public abstract class BaseSolver {

    private String path;

    protected BaseSolver(String path) {
        this.path = path;
    }

    protected abstract void question1(List<String> fileLines);

    protected abstract void question2(List<String> fileLines);

    public void solve() {
        try {
            var lines = BaseSolver.readFile(this.path);
            System.out.println("Output for question 1:");
            this.question1(lines);
            System.out.println("=============================");
            System.out.println("Output for question 2:");
            this.question2(lines);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    private static List<String> readFile(String fileName) throws IOException {
        Path filePath = Paths.get(fileName);
        return Files.readAllLines(filePath);
    }
}
