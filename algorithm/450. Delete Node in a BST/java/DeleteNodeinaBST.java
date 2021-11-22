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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root!=null){
            if(root.val==key){
                TreeNode cur = root.right;
                if(cur==null) return root.left;
                if(cur.left==null){ 
                    cur.left=root.left;
                    return cur;
                }
                while(cur.left.left!=null) cur=cur.left;
                TreeNode temp = cur.left;
                cur.left = cur.left.right;
                temp.left=root.left;
                temp.right=root.right;
                // delete root; // C++
                return temp;
            }
            if(key<root.val){
                root.left = deleteNode(root.left, key);
            }
            else{
                root.right = deleteNode(root.right, key);
            }        
        }
        return root;
    }
}
