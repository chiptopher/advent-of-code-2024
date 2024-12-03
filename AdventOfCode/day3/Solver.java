package AdventOfCode.day3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import AdventOfCode.BaseSolver;

class Solver extends BaseSolver {

    protected Solver(String path) {
        super(path);
    }

    @Override
    protected void question1(List<String> fileLines) {
        int sum = 0;
        for (String line : fileLines) {
            var multiplicationBlocksMatcher = getMatcherForMultiplicationBlocks().matcher(line);
            while (multiplicationBlocksMatcher.find()) {
                var section = multiplicationBlocksMatcher.group();
                var inputsMatcher = getInputsMatcher().matcher(section);
                List<Integer> inputs = new ArrayList<>();
                while (inputsMatcher.find()) {
                    inputs.add(Integer.parseInt(inputsMatcher.group()));
                }

                sum += inputs.stream().reduce(1, (a, b) -> a * b);
            }
        }
        System.out.println(sum);
    }

    @Override
    protected void question2(List<String> fileLines) {
    }

    private Pattern getMatcherForMultiplicationBlocks() {
        String multiplicationSectionMatcher = "mul\\(\\d+,\\d+\\)"; // Escaped parentheses and comma
        return Pattern.compile(multiplicationSectionMatcher);
    }

    private Pattern getInputsMatcher() {
        return Pattern.compile("(\\d+)");
    }
}
