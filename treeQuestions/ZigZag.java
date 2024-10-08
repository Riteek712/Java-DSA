package treeQuestions;

public class ZigZag {
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
    int maxi = 0;
    public void ziggy(TreeNode root, int dir, int dis){ // in dir : 0 = left & 1 = right
        if(root==null){
            return;
        }
        if(dir == 0 && root.right != null){
            dis++;
            maxi = Math.max(maxi, dis);
            ziggy(root.right, 1, dis);
        }else{
            ziggy(root.right, 1, 1);
        }
        if(dir == 1 && root.left != null){
            dis++;
            maxi = Math.max(maxi, dis);
            ziggy(root.left,0, dis);
        }else{
            ziggy(root.left,0, 1);
        }
        maxi = Math.max(maxi, dis);

       
        return;
    }
    public int longestZigZag(TreeNode root) {
        if(root==null){
            return 0;
        }
        ziggy(root.left, 0, 1);
        ziggy(root.right, 1, 1);
        return maxi;

    }
}
