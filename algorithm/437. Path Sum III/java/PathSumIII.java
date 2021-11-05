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
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        int leftEx = 0, rightEx = 0, leftIn = 0, rightIn = 0;
        // for one path, we can only exclude current Tree node for one time during the travesal
        // that means we cannot have(Notice the difference):
        // leftEx = pathSum(root.left, targetSum);
        // rightEx = pathSum(root.right, targetSum);
        // leftIn = pathSum(root.left, targetSum-root.val);
        // rightIn = pathSum(root.right, targetSum-root.val);
        // instead we should write a function that count only the path fron root node to the leaf and record all the path that has targetSum
        leftEx = pathSum(root.left, targetSum);
        rightEx = pathSum(root.right, targetSum);
        leftIn = pathSumRoot(root.left, targetSum-root.val);
        rightIn = pathSumRoot(root.right, targetSum-root.val);
        if(targetSum == root.val){
            return 1+leftEx+rightEx+leftIn+rightIn;
        }
        return leftEx+rightEx+leftIn+rightIn;
    }
    
    private int pathSumRoot(TreeNode root, int targetSum){
        if(root==null) return 0;
        int left = 0, right = 0;
        left = pathSumRoot(root.left, targetSum-root.val);
        right = pathSumRoot(root.right, targetSum-root.val);
        if(targetSum == root.val){
            return 1+left+right;
        }
        return left+right;
    }
}
