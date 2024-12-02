package AdventOfCode;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public abstract class BaseSolver {

    private String path;

    protected BaseSolver(String path) {
        this.path = path;
    }

    protected abstract void question(List<String> fileLines);

    public void solve() {
        try {
            var lines = BaseSolver.readFile(this.path);
            this.question(lines);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    private static List<String> readFile(String fileName) throws IOException {
        Path filePath = Paths.get(fileName);
        return Files.readAllLines(filePath);
    }
}
