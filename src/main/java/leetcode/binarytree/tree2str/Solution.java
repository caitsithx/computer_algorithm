package leetcode.binarytree.tree2str;

import static leetcode.binarytree.inorder.MainClass.stringToTreeNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import leetcode.binarytree.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
   private StringBuilder builder = new StringBuilder();

   public String tree2str(TreeNode t) {
      tree2str1(t);
      return builder.toString();
   }

   private void tree2str1(TreeNode t) {
      if (t == null) {
         return;
      }

      builder.append(t.val);
      if (t.right == null && t.left == null) {
         return;
      }


      builder.append('(');
      tree2str1(t.left);
      builder.append(')');

      if(t.right != null) {
         builder.append('(');
         tree2str1(t.right);
         builder.append(')');
      }
   }

   public static void main(String[] args) throws IOException {
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      String line;
      while ((line = in.readLine()) != null) {
         TreeNode root = stringToTreeNode(line);

         System.out.print(new Solution().tree2str(root));
      }
   }
}
