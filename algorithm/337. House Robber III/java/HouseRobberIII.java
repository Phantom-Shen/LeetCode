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
// use a size 2 array to record cur and prev as did in House Robber I and II.
// not sure if this is optimal.
// notice if trying to re-write it in C or C++ or other language that requires memory management, remember to drop unused memory
class Solution {
    public int rob(TreeNode root) {
        int[] result = recur(root);
        return result[0];
    }
    
    private int[] recur(TreeNode root){
        if(root==null) return new int[2];
        int[] left = recur(root.left);
        int[] right = recur(root.right);
        int result = 0;
        result = Math.max(left[0]+right[0], root.val+left[1]+right[1]);
        left[1] = left[0]+right[0];
        left[0] = result;
        return left;
    }
}
