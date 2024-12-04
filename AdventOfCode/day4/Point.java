package AdventOfCode.day4;

import java.util.List;

class Point {
    private int x;
    private int y;
    private List<String> data;
    private char value;

    public Point(int x, int y, List<String> data, char value) {
        this.x = x;
        this.y = y;
        this.data = data;
        this.value = value;
    }

    public int checkForAllDirections() {
        int sum = 0;
        if (this.next(1, 1) != null) {
            sum++;
        }
        if (this.next(1, 0) != null) {
            sum++;
        }
        if (this.next(1, -1) != null) {
            sum++;
        }
        if (this.next(0, -1) != null) {
            sum++;
        }
        if (this.next(-1, -1) != null) {
            sum++;
        }
        if (this.next(-1, 0) != null) {
            sum++;
        }
        if (this.next(-1, 1) != null) {
            sum++;
        }

        return sum;
    }

    public Point next(int xTransform, int yTransform) {
        int newX = this.x + xTransform;
        int newY = this.y + yTransform;

        if (this.isInvalidPoint(newX, newY)) {
            return null;
        }

        char nextValue = getAtPoint(newX, newY);
        Point next = null;
        switch (this.value) {
            case 'X': {
                if (nextValue == 'M') {
                    next = new Point(newX, newY, this.data, nextValue);
                }
            }
            case 'M': {
                if (nextValue == 'A') {
                    next = new Point(newX, newY, this.data, nextValue);
                }
            }
            case 'A': {
                if (nextValue == 'S') {
                    return this;
                }
            }
        }

        if (next != null) {
            System.out.println("Going from {" + this + " -> " + next + "}");
            return next.next(xTransform, yTransform);
        }

        return null;

    }

    private char getAtPoint(int x, int y) {
        return this.data.get(y).charAt(x);
    }

    private boolean isInvalidPoint(int newX, int newY) {
        return newX < 0
                || newY < 0
                || newX >= this.data.get(0).length()
                || newY >= this.data.size();
    }

    public String toString() {
        return "[" + this.x + "," + this.y + " | " + this.value + "]";
    }
}
