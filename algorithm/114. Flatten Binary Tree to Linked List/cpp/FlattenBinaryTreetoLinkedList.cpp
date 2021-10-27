/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
// has recursion stack memory
class Solution {
public:
    void flatten(TreeNode* root) {
        if(root){
            temp = root;
            flatten(root->left);
            TreeNode *tail = temp; // kind of like managing shared resource in multithreading
            flatten(root->right);
            tail->right = root->right;
            if(root->left){ // only if there is something on the left subtree, we concatenate the head of right subtree to the tail of left subtree
                root->right = root->left;
                root->left = NULL;
            }
        }
    }
private:
    TreeNode *temp; // used to record the right most node(tail) of subtrees.
};

/*
// Morris Traversal.
class Solution {
public:
    void flatten(TreeNode* root) {
        while (root) {
            if (root -> left) {
                TreeNode* pre = root -> left;
                while (pre -> right) {
                    pre = pre -> right;
                }
                pre -> right = root -> right;
                root -> right = root -> left;
                root -> left = NULL;
            }
            root = root -> right;
        }
    }
};
*/
