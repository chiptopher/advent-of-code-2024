package AdventOfCode.day2;

import java.util.List;

import AdventOfCode.BaseSolver;

public class Main {
    public static void main(String[] args) {
        new Solver().solve();
    }

}

class Solver extends BaseSolver {

    Solver() {
        super("AdventOfCode/day2/input.txt");
    }

    @Override
    protected void question(List<String> fileLines) {
        System.out.println("Contents of input.txt:");
        for (String line : fileLines) {
            System.out.println(line);
        }
    }
}
