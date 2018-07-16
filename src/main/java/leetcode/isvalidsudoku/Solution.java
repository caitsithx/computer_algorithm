package leetcode.isvalidsudoku;

class Solution {
   public boolean isValidSudoku(char[][] board) {
      return checkRow(board) && checkColumn(board) && check33(board);
   }

   private boolean check33(char[][] board) {
      for (int i = 0; i < 9; i+=3) {
         for (int j = 0; j < 9; j+=3) {
            int[] tmp = new int[10];
            for (int k = 0; k < 3; k++) {
               for (int l = 0; l < 3; l++) {
                  char ch = board[i + k][j + l];
                  if (ch == '.') continue;

                  if (tmp[ch - 0x30] != 0) {
                     return false;
                  }

                  tmp[ch - 0x30] = 1;
               }
            }
         }
      }

//      System.out.println("check33");

      return true;
   }

   private boolean checkColumn(char[][] board) {
      for (int i = 0; i < 9; i++) {
         int[] tmp = new int[10];
         for (int j = 0; j < 9; j++) {
            char ch = board[j][i];
            if (ch == '.') continue;

            if (tmp[ch - 0x30] != 0) {
               return false;
            }

            tmp[ch - 0x30] = 1;
         }
      }

//      System.out.println("checkColumn");


      return true;
   }

   private boolean checkRow(char[][] board) {
      for (char[] row : board) {
         int[] tmp = new int[10];
         for (char ch : row) {
            if (ch == '.') continue;
            if (tmp[ch - 0x30] != 0) {
               return false;
            }

            tmp[ch - 0x30] = 1;
         }
      }

//      System.out.println("checkRow");
      return true;
   }


   static char[][] inputs = {
         {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
         {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
         {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
         {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
         {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
         {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
         {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
         {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
         {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
   };

   public static void main(String[] args) {
      System.out.println(new Solution().isValidSudoku(inputs));
   }
}
