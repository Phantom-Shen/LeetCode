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
// very similar to "105. Construct Binary Tree from Preorder and Inorder Traversal"
class Solution {
    private int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        Map<Integer, Integer> mp = new HashMap();
        index = n-1;
        for(int i = 0; i < n; i++){
            mp.put(inorder[i], i);
        }
        return recur(mp, postorder, 0, n-1);
    }
    
    private TreeNode recur(Map<Integer, Integer> inorder, int[] postorder, int l, int r){
        if(index<0||l>r) return null;
        
        int curVal = postorder[index];
        TreeNode newNode = new TreeNode(curVal);
        index--;
        newNode.right = recur(inorder, postorder, inorder.get(curVal)+1, r);
        newNode.left = recur(inorder, postorder, l, inorder.get(curVal)-1);
        return newNode;
    }
}
