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
// Not good for concurrency apparently. Could solve this with iterative way
// BUT, recursion is really easy and fast to write :D
class Solution {
    public int sumNumbers(TreeNode root) {
        if(root.left==null && root.right==null) return root.val;
        int left = 0, right = 0;
        if(root.left!=null){
            root.left.val += 10*root.val;
            left = sumNumbers(root.left);
        }
        if(root.right!=null){
            root.right.val += 10*root.val;
            right = sumNumbers(root.right);
        }
        return left+right;
    }
}
