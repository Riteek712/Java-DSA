package treeQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class LowestCommonAncestor {

    // TreeNode class definition
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Solution class definition
    static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // Base case
            if (root == null || root == p || root == q) {
                return root;
            }

            // Search in left and right subtrees
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            // If both left and right are non-null, root is the LCA
            if (left != null && right != null) {
                return root;
            }

            // Otherwise, return the non-null value
            return left != null ? left : right;
        }
    }// Function to print the tree
    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        // Level-order traversal using a queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    System.out.print(node.val + " ");
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                } else {
                    System.out.print("null ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Create the binary tree
        TreeNode root = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);

        // Build the tree structure
        root.left = node5;
        root.right = node1;
        node5.left = node6;
        node5.right = node2;
        node1.left = node0;
        node1.right = node8;
        node2.left = node7;
        node2.right = node4;
        printTree(root);
        
        // Define nodes p and q
        TreeNode p = node5; // Node with value 5
        TreeNode q = node1; // Node with value 1

        // Create a Solution object and find the LCA
        Solution solution = new Solution();
        TreeNode lca = solution.lowestCommonAncestor(root, p, q);

        // Output the result
        if (lca != null) {
            System.out.println("The Lowest Common Ancestor of nodes " + p.val + " and " + q.val + " is: " + lca.val);
        } else {
            System.out.println("Lowest Common Ancestor not found.");
        }
    }
}
