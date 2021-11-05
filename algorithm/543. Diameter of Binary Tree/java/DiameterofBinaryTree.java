/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] result = new int[1];
        recur(root, result);
        return result[0];
    }
    
    private int recur(TreeNode root, int[] result){
        if(root.left==null && root.right==null) return 1;
        int left = 0, right = 0;
        if(root.left!=null) left = recur(root.left, result);
        if(root.right!=null) right = recur(root.right, result);
        result[0] = Math.max(result[0], left+right);
        return 1+Math.max(left,right);
    }
}
