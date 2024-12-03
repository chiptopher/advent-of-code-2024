package AdventOfCode.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import AdventOfCode.BaseSolver;

class Solver extends BaseSolver {

    Solver() {
        super("AdventOfCode/day1/input.txt");
    }

    @Override
    protected String question1(List<String> fileLines) {
        int sum = 0;
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        for (String line : fileLines) {
            first.add(Integer.parseInt(line.split("   ")[0]));
            second.add(Integer.parseInt(line.split("   ")[1]));
        }

        Collections.sort(first);
        Collections.sort(second);

        for (int i = 0; i < first.size(); i++) {
            sum += Math.abs(first.get(i) - second.get(i));
        }

        return Integer.toString(sum);
    }

    @Override
    protected String question2(List<String> fileLines) {
        int sum = 0;
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        for (String line : fileLines) {
            first.add(Integer.parseInt(line.split("   ")[0]));
            second.add(Integer.parseInt(line.split("   ")[1]));
        }

        for (Integer number : first) {
            var count = second.stream()
                    .filter(v -> v.equals(number))
                    .collect(Collectors.toList())
                    .size();
            sum += (number * count);
        }

        return Integer.toString(sum);
    }

}
