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
    int curi;
    Map<Integer, Integer> mp;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        curi = 0;
        mp = new HashMap<>();
        for(int i = 0;i < inorder.length; i++){
            mp.put(inorder[i],i);
        }
        return recur(preorder, 0, preorder.length-1);
    }
    
    private TreeNode recur(int[] preorder, int l, int r){
        if(l > r) return null;
        int curVal = preorder[curi];
        TreeNode newNode = new TreeNode(curVal);
        curi++;
        newNode.left = recur(preorder, l, mp.get(curVal)-1);
        newNode.right = recur(preorder, mp.get(curVal)+1, r);
        return newNode;
    }
}
