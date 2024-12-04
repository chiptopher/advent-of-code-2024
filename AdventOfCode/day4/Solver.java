package AdventOfCode.day4;

import java.util.List;

import AdventOfCode.BaseSolver;

class Solver extends BaseSolver {

    protected Solver(String path) {
        super(path);
    }

    @Override
    protected String question1(List<String> fileLines) {
        int count = 0;
        int lengthOfRow = fileLines.get(0).length();
        var joined = String.join("", fileLines);
        int[] cardinals = {
                1,
                -1,
                lengthOfRow,
                lengthOfRow * -1,
                lengthOfRow + 1,
                lengthOfRow - 1,
                -1 * (lengthOfRow + 1),
                -1 * (lengthOfRow - 1)
        };

        for (int startIndex = 0; startIndex < joined.length(); startIndex++) {
            if (joined.charAt(startIndex) == 'X') {
                for (int space : cardinals) {
                    var created = createStringFromStartingPointWithSpace(joined, startIndex, space, lengthOfRow);
                    if (created.equals("XMAS")) {
                        count++;
                    }
                }
            }
        }

        return Integer.toString(count);
    }

    @Override
    protected String question2(List<String> fileLines) {
        return "Not done yet";
    }

    private String createStringFromStartingPointWithSpace(String base, int startingIndex, int space, int lineLength) {
        StringBuilder build = new StringBuilder();
        int i = startingIndex;
        int previousMode = i % lineLength;

        while (i >= 0 && i < base.length() && build.length() < 4
                && !leftRightEdgeCase(previousMode, i % lineLength, previousMode)) {

            build.append(base.charAt(i));
            previousMode = i % lineLength;
            i = i + space;
        }
        return build.toString();
    }

    private boolean leftRightEdgeCase(int startingMod, int currentMod, int previous) {
        if (startingMod == currentMod) {
            return false;
        }

        return Math.abs(startingMod - currentMod) > 1;
    }
}
