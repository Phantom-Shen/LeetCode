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
// use std::pair would make the code look cleaner
class Solution {
public:
    int rob(TreeNode* root) {
        vector<int> temp = recur(root);
        int result = temp[0];
        // release memory
        vector<int>().swap(temp);
        return result;
    }
    
private:
    vector<int> recur(TreeNode* root){
        if(!root) return vector<int>(2,0);
        vector<int> left = recur(root->left);
        vector<int> right = recur(root->right);
        int curMax = max(left[0]+right[0], root->val+left[1]+right[1]);
        left[1] = left[0]+right[0];
        left[0] = curMax;
        // release memory
        vector<int>().swap(right);
        return left;
    }
};
