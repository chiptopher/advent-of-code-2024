package AdventOfCode.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import AdventOfCode.BaseSolver;

class Solver extends BaseSolver {

    Solver() {
        super("AdventOfCode/day2/input.txt");
    }

    @Override
    protected void question1(List<String> fileLines) {
        int safeLevels = 0;
        for (String rawLevelData : fileLines) {
            List<Integer> numbers = Arrays.stream(rawLevelData.split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            if (isFloorSafe(numbers)) {
                safeLevels++;
            }

        }
        System.out.println("[part 1] Number of safe floors is: " + safeLevels);
    }

    @Override
    protected void question2(List<String> fileLines) {
        int safeLevels = 0;
        for (String rawLevelData : fileLines) {
            List<Integer> numbers = Arrays.stream(rawLevelData.split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            if (isFloorSafe(numbers)) {
                safeLevels++;
            } else {
                int i = 0;
                while (i < numbers.size()) {
                    var copy = new ArrayList<>(numbers);
                    copy.remove(i);
                    if (isFloorSafe(copy)) {
                        safeLevels++;
                        break;
                    }
                    i++;
                }
            }

        }
        System.out.println("[part 1] Number of safe floors is: " + safeLevels);
    }

    private boolean isFloorSafe(List<Integer> floorData) {
        int i = 0;
        var previousDifference = calculateFloorDifferenceAtIndex(floorData, 0);
        while (i < floorData.size() - 1) {
            var difference = calculateFloorDifferenceAtIndex(floorData, i);
            if (difference == 0) {
                return false;
            }
            if (calculateIfDiectionIsChanged(previousDifference, difference)) {
                return false;
            }
            if (Math.abs(difference) > 3) {
                return false;
            }

            previousDifference = difference;
            i++;
        }

        return true;
    }

    private int calculateFloorDifferenceAtIndex(List<Integer> floorData, int index) {
        var current = floorData.get(index);
        var next = floorData.get(index + 1);
        return current - next;
    }

    private boolean calculateIfDiectionIsChanged(int previous, int current) {
        if (previous == 0) {
            return false;
        }

        return (previous > 0 != current > 0);
    }

}
