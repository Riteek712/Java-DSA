package treeQuestions;

public class CountCompleteNodes {
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


    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }

        return countNodes(root.left) +countNodes(root.right) +1;

    }
}
