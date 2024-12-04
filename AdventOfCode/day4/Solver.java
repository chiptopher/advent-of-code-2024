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
                    var created = createStringFromStartingPointWithSpace(joined, startIndex, space);
                    if (created.equals("XMAS")) {
                        System.out.println(created);
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

    private String createStringFromStartingPointWithSpace(String base, int startingIndex, int space) {
        System.out.println("Starting with " + startingIndex + " with cardinality of " + space);
        StringBuilder build = new StringBuilder();
        for (int i = startingIndex; i >= 0 && i < base.length() && build.length() < 4; i += space) {
            build.append(base.charAt(i));
        }
        return build.toString();
    }
}
