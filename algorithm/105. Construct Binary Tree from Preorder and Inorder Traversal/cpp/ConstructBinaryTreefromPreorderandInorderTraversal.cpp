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
class Solution {
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        unordered_map<int,int> mp;
        for(int i = 0; i < inorder.size(); i++){
            mp[inorder[i]] = i;
        }
        int curi = 0;
        return recur(preorder, mp, &curi, 0, inorder.size()-1);
    }
private:
    TreeNode *recur(vector<int>& preorder, unordered_map<int,int>& inorder, int *curi, int l, int r){
        if(l <= r){
            int curVal = preorder[*curi];
            TreeNode *newNode = new TreeNode(curVal);
            *curi += 1;
            newNode->left = recur(preorder, inorder, curi, l, inorder[curVal]-1);
            newNode->right = recur(preorder, inorder, curi, inorder[curVal]+1, r);
            return newNode;
        }
        return NULL;
    }
};
/*
// Use a cursor to traverse step by step. 
// After all the left sub tree finishes, cursor would have already incremented and reach the index of the starting point of right subtrees.
// Remember to check l <= r, where l and r represent the inorder index, since we are partitioning the subtrees with the inorder array. 

class Solution {
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        for(int i = 0; i < inorder.size(); i++){
            inordermp[inorder[i]] = i;
        }
        int cur = 0;
        return recur(preorder, 0, &cur, preorder.size()-1);
    }
private:
    unordered_map<int,int> inordermp;
    TreeNode *recur(vector<int>& preorder, int l, int *cur, int r){
        if(l<=r){
            int inorder = inordermp[preorder[*cur]];
            TreeNode *newNode = new TreeNode(preorder[*cur]);
            *cur += 1;
            newNode->left = recur(preorder, l, cur, inorder-1);
            newNode->right = recur(preorder, inorder+1, cur, r);
            return newNode;
        }
        return NULL;
    }
};
*/
/*
// pre: root left right
// in: left root right
class Solution {
public:
    int prei;
    unordered_map<int,int> in;
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        prei = 0;
        for(int i = 0 ; i < inorder.size(); i++){
            in[inorder[i]] = i; // key: value, value: index of value in inorder;
        }
        return recur(preorder,0,preorder.size()-1);
    }
    
private:
    TreeNode *recur(vector<int>& preorder, int l, int r){
        if(l<=r){
            int curval = preorder[prei++];
            TreeNode* cur = new TreeNode(curval);
            cur->left = recur(preorder,l,in[curval]-1);
            cur->right = recur(preorder,in[curval]+1, r);
            return cur;
        }
        return NULL;
    } 
};*/
