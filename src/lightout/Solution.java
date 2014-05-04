package lightout;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    /* Complete the function below to print 2 integers separated by a single space which will be your next move */
    static void nextMove(int player, String [] board){
        int[] secondCandidate = null;
        int[] firstCandidate = null;
        for(int i =0; i < board.length; i ++) {
            for(int j = 0; j < board[i].length(); j ++) {
                //possible
                if(board[i].charAt(j) == '1') {
                    if((j+1) < board[i].length() && board[i].charAt(j+1) == '1') {
                        //perfect shoot
                         if((i+1) < board.length && board[i+1].charAt(j) == '1') {
                            firstCandidate = new int[] {i, j};
                            break;
                        }
                    }
                }
            }

            if(firstCandidate != null) {
                System.out.print(firstCandidate[0]);
                System.out.print(' ');
                System.out.println(firstCandidate[1]);
                return;
            }
        }

        for(int i =0; i < board.length; i ++) {
            for(int j = 0; j < board[i].length(); j ++) {
                if(board[i].charAt(j) == '1') {
                    if((j+1) < board[i].length() && board[i].charAt(j+1) == '1') {
                       //i+1,j -> i+2,j;i+1,j-1;i+1,j+1
                        if(i+2 < board.length && board[i+2].charAt(j) == '1') {
                            secondCandidate = new int[] {i+2, j};
                            break;
                        } else if(i+1 < board.length && j-1 > -1 && board[i+1].charAt(j-1) == '1') {
                            secondCandidate = new int[] {i+1, j-1};
                            break;
                        } else if(i+1 < board.length && j+1 <board[i+1].length() && board[i+1].charAt(j+1) == '1') {
                            secondCandidate = new int[] {i+1, j+1};
                            break;
                        }
                    } else if ((i+1) < board.length && board[i+1].charAt(j) == '1') {
                        //i, j+1 -> i-1,j+1;i+1,j+1;i,j+2
                        if(i-1 > 0 && j+1 < board[i-1].length() && board[i-1].charAt(j+1) == '1') {
                            secondCandidate = new int[] {i-1, j+1};
                            break;
                        } else if(i+1 < board.length && j+1 < board[i+1].length() && board[i+1].charAt(j+1) == '1') {
                            secondCandidate = new int[] {i+1, j+1};
                            break;
                        } else if(j+2 <board[i].length() && board[i].charAt(j+2) == '1') {
                            secondCandidate = new int[] {i, j+2};
                            break;
                        }
                    }
                }
            }
            if(secondCandidate != null){
                System.out.print(secondCandidate[0]);
                System.out.print(' ');
                System.out.println(secondCandidate[1]);
                return;
            }
        }

        for(int i =0; i < board.length; i ++) {
            for(int j = 0; j < board[i].length(); j ++) {
                if(board[i].charAt(j) == '1') {
                    System.out.print(i);
                    System.out.print(' ');
                    System.out.println(j);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int player;
        String board[] = new String[8];

        //If player is 1, I'm the first player.
        //If player is 2, I'm the second player.
        player = in.nextInt();

        //Read the board now. The board is a 8x8 array filled with 1 or 0.
        for(int i = 0; i < 8; i++) {
            board[i] = in.next();
        }

        nextMove(player,board);

    }
}
