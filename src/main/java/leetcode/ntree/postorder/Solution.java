package leetcode.ntree.postorder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import leetcode.ntree.Node;

class Solution {
   public List<Integer> postorder(Node root) {
      if(root == null) return Collections.emptyList();

      List<Integer> result = new ArrayList<>();

      if(root.children != null) {
         for (Node child : root.children) {
            result.addAll(postorder(child));
         }
      }

      result.add(root.val);

      return result;
   }
}
