package AdventOfCode.day4;

import java.util.ArrayList;
import java.util.List;

import AdventOfCode.BaseSolver;

class Solver extends BaseSolver {

    protected Solver(String path) {
        super(path);
    }

    @Override
    protected String question1(List<String> fileLines) {
        List<Point> startingPoints = new ArrayList<>();
        for (int y = 0; y < fileLines.size(); y++) {
            for (int x = 0; x < fileLines.get(y).length(); x++) {
                if (fileLines.get(y).charAt(x) == 'X') {
                    startingPoints.add(new Point(x, y, fileLines, 'X'));
                }
            }
        }

        int count = startingPoints.stream()
                .map(Point::checkForAllDirections)
                .reduce(0, (a, b) -> a + b);

        return Integer.toString(count);
    }

    @Override
    protected String question2(List<String> fileLines) {
        return "Not done yet";
    }
}
