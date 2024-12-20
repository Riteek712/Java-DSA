package treeQuestions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


     public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
      return new ArrayList<>();

    List<Integer> ans = new ArrayList<>();
    Queue<TreeNode> q = new ArrayDeque<>(List.of(root));

    while (!q.isEmpty()) {
      final int size = q.size();
      for (int i = 0; i < size; ++i) {
        TreeNode node = q.poll();
        if (i == size - 1)
          ans.add(node.val);
        if (node.left != null)
          q.offer(node.left);
        if (node.right != null)
          q.offer(node.right);
      }
    }

    return ans;

    }
}
