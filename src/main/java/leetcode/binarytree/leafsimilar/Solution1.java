package leetcode.binarytree.leafsimilar;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import leetcode.binarytree.TreeNode;

public class Solution1 {
   public boolean leafSimilar(TreeNode root1, TreeNode root2) {
      if(root1 == null && root2 == null) {
         return true;
      } else if (root1 == null || root2 == null){
         return false;
      }

      Stack<TreeNode> history1 = new Stack<>();
      Stack<TreeNode> history2 = new Stack<>();

      TreeNode current1 = root1;
      TreeNode current2 = root2;
      Queue<TreeNode> leaves1 = new LinkedList<>();
      Queue<TreeNode> leaves2 = new LinkedList<>();
      while ((current1 != null || !history1.empty()) || (current2 != null || !history2.empty())) {
         while(current1 != null) {
            history1.push(current1);
            current1 = current1.left;
         }

         while(current2 != null) {
            history2.push(current2);
            current2 = current2.left;
         }

         if(!history1.isEmpty()) {
            current1 = history1.pop();
            if (current1.left == null && current1.right == null) {
               System.out.println("left: " + current1.val);
               if (leaves2.isEmpty()) {
                  leaves1.add(current1);
               } else {
                  if (leaves2.poll().val != current1.val) {
                     return false;
                  }
               }
            }
            current1 = current1.right;
         }

         if(!history2.isEmpty()) {
            current2 = history2.pop();
            if (current2.left == null && current2.right == null) {
               System.out.println("right: " + current2.val);
               if (leaves1.isEmpty()) {
                  leaves2.add(current2);
               } else {
                  if (leaves1.poll().val != current2.val) {
                     return false;
                  }
               }
            }

            current2 = current2.right;
         }
      }

      return leaves1.isEmpty() && leaves2.isEmpty();
   }
}
