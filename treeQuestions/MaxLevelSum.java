package treeQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxLevelSum {
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

    public List<Integer> lot(TreeNode root){
        List<Integer> res = new ArrayList<>();
        int temp = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            if(curr == null){
                res.add(temp);
                if(q.isEmpty()){
                    break;
                }
                temp = 0;
                q.add(null);
            }else{
                temp += curr.val;
            if(curr.left != null) q.add(curr.left);
            if(curr.right != null) q.add(curr.right);
            }
            
        }
        return res;
    }
    public int maxLevelSum(TreeNode root) {
        List<Integer> sums = lot(root);
        int index = 0;
        // int max = sums.get(index);
        for(int i = 0; i < sums.size(); i++){
            if(sums.get(i)>sums.get(index)){
                index = i;
            }
        }
        return index+1;
    }
}
