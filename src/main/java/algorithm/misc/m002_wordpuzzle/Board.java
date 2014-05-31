package algorithm.misc.m002_wordpuzzle;

/**
 * Created by lixl on 5/31/14.
 */
public final class Board {
    private char[][] arrays = null;

    public Board(int columnNum, int rowNum, String[] inputs) {
        if (inputs.length != rowNum) {
            throw new IllegalArgumentException();
        }

        arrays = new char[rowNum][];

        for (int i = 0; i < arrays.length; i++) {
            if (inputs[i].length() != columnNum) {
                throw new IllegalArgumentException("input size wrong @ row " + i);
            }

            arrays[i] = inputs[i].toCharArray();
        }
    }

    public int[] getSizes() {
        return new int[] {arrays[0].length, arrays.length};
    }

    public BoardIterator iterator(int x, int y) {
        return new BoardIterator();
    }


    public enum DIRECT {
        LEFT, RIGHT, UP, DOWN, UP_LEFT, UP_RIGHT, DOWN_LEFT, DOWN_RIGHT
    }

    public class BoardIterator {
        private int[] position = {0, 0};

        private BoardIterator() {
        }

        public boolean hasNext(DIRECT direct) {
            return false;
        }

        public char next(DIRECT direct) {
            return 'a';
        }
    }

}
