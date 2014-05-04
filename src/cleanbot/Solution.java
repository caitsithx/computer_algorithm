package cleanbot;

import java.util.Scanner;

public class Solution {
    static void next_move(int posr, int posc, int dimh, int dimw, String[] board){
        char[][] chars = new char[board.length][board[0].length()];
        for(int i = 0; i < board.length; i ++) {
            chars[i] = board[i].toCharArray();
        }

        String ret = null;
        if(chars[posr][posc] == 'd') {
            ret = "CLEAN";
            chars[posr][posc] = '-';
            board[posr] = new String(chars[posr]);
        } else {
            for(int i = 1; i < (board.length - 1) * 2; i ++) {
                int[] next = findNextD(posr, posc, chars, i);

                if(next != null) {
                    if(next[0] < posr) {
                        ret = "UP";
                    } else if (next[0] > posr) {
                        ret = "DOWN";
                    } else {
                        if(next[1] < posc) {
                            ret = "LEFT";
                        } else if (next[1] > posc) {
                            ret = "RIGHT";
                        }
                    }

                    break;
                }
            }
        }
        System.out.println(ret);
    }

    static int[] findNextD(int posr, int posc, char[][] chars, int distance){
        int[] next = new int[]{-1, -1};
        for(next[0] = posr; next[0] < chars.length && (next[0] - posr) <= distance; next[0] ++) {
            next[1] = posc - (next[0] - posr) + distance;
            if(next[1] < chars[0].length) {
                if(chars[next[0]][next[1]] == 'd') {
                    return next;
                }
            }

            next[1] = posc + (next[0] - posr) - distance;
            if(next[1] > -1) {
                if(chars[next[0]][next[1]] == 'd') {
                    return next;
                }
            }
        }

        for(next[0] = posr; next[0] > -1 && (posr - next[0]) <= distance ; next[0] --) {
            next[1] = posc - (posr - next[0]) + distance;
            if(next[1] < chars[0].length) {
                if(chars[next[0]][next[1]] == 'd') {
                    return next;
                }
            }

            next[1] = posc + (posr - next[0]) - distance;
            if(next[1] > -1) {
                if(chars[next[0]][next[1]] == 'd') {
                    return next;
                }
            }
        }

        return null;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int [] pos = new int[2];
        int [] dim = new int[2];
        for(int i=0;i<2;i++) pos[i] = in.nextInt();
        for(int i=0;i<2;i++) dim[i] = in.nextInt();
        String board[] = new String[dim[0]];
        for(int i=0;i<dim[0];i++) board[i] = in.next();
        next_move(pos[0], pos[1], dim[0], dim[1], board);
    }
}