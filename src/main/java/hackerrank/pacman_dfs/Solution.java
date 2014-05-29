package hackerrank.pacman_dfs;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        int pacman_r = in.nextInt();
        int pacman_c = in.nextInt();

        int food_r = in.nextInt();
        int food_c = in.nextInt();

        int r = in.nextInt();
        int c = in.nextInt();

        String grid[] = new String[r];

        for(int i = 0; i < r; i++) {
            grid[i] = in.next();
        }

        dfs( r, c, pacman_r, pacman_c, food_r, food_c, grid);
    }

    static void dfs(int r, int c, int pacman_r, int pacman_c, int food_r, int food_c, String [] grid){
        Solution sol = new Solution();
        Dot dot = sol.new Dot();
        dot.aChar = 'P';
        dot.columnNum = pacman_c;
        dot.rowNum = pacman_r;

        LinkedList<Dot> path = new LinkedList<Dot>();
        path.add(dot);
        sol.travelNeighbors(grid, path);

        System.out.println(sol.path.size());

        for(Dot dot1 : sol.path) {
            System.out.println(dot1);
        }
    }

    class Dot {
        int rowNum, columnNum;
        char aChar;

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(rowNum).append(' ').append(columnNum);
            return sb.toString();
        }

        public int hashCode() {
            int code = rowNum;
            code = columnNum + 37 * code;
            code += aChar + 37 * code;

            return code;
        }

        public boolean equals(Object another) {
            if(!(another instanceof Dot)) {
                return  false;
            }

            Dot anotherDot = (Dot)another;
            return anotherDot.columnNum == columnNum && anotherDot.rowNum == rowNum && anotherDot.aChar == aChar;
        }

    }

    enum Direction {
        DOWN,RIGHT,LEFT,UP
    }

    boolean ate = false;

    LinkedList<Dot> path = new LinkedList<Dot>();
    public boolean travelNeighbors(String[] grid, LinkedList<Dot> currentPath) {
        if(currentPath.getLast().aChar == '.') {
            path = currentPath;
            return true;
        }

        for(Direction direct : Direction.values()) {
            try {
                Dot newDot = move(grid, currentPath.getLast().rowNum, currentPath.getLast().columnNum, direct);

                if(currentPath.contains(newDot)) {
                    continue;
                }

                if(newDot.aChar == '%') {
                    continue;
                }

                LinkedList<Dot> newPath = new LinkedList<Dot>();
                newPath.addAll(currentPath);
                newPath.add(newDot);

                if(travelNeighbors(grid, newPath)) {
                    return true;
                }
            } catch (IllegalArgumentException illegalArg) {
                illegalArg.toString();
            }
        }

        return false;
    }

    public Dot move(String[] grid, int current_r, int current_c, Direction direct) {
        Dot newDot = null;

        newDot = new Dot();
        switch (direct) {
            case UP:
                newDot.rowNum = (current_r - 1);
                newDot.columnNum = current_c;
                break;
            case DOWN:
                newDot.rowNum = (current_r + 1);
                newDot.columnNum = current_c;
                break;
            case LEFT:
                newDot.rowNum = (current_r);
                newDot.columnNum = current_c - 1;
                break;
            case RIGHT:
                newDot.rowNum = (current_r);
                newDot.columnNum = current_c + 1;
                break;
        }

        if(newDot.rowNum < 0 || newDot.rowNum >= grid.length || newDot.columnNum < 0 || newDot.columnNum >= grid[0].length()) {
            throw new IllegalArgumentException();
        }

        newDot.aChar = grid[newDot.rowNum].charAt(newDot.columnNum);

        return newDot;
    }
}