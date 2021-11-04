class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size(), prev = 0, cur = 0, result;
        for(int i = 0; i < n ; i++){
            result = max(prev+nums[i], cur);
            prev = cur;
            cur = result;
        }
        return result;
    }
};
/*
class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size(), prev = 0, cur = 0;
        for(int i = 0; i < n; i++){
            int temp = max(prev + nums[i], cur);
            prev = cur;
            cur = temp;
        }
        return cur;
    }
};
*/
/*
class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size(), prev = 0,  cur = 0;
        for(int i = 0; i < n; i++){
            // calculate max profit at i, prev is the max profit at i-2, last cur is max profit at i-1
            int temp = max(prev+nums[i], cur); 
            prev = cur;  
            cur = temp;
            cout << cur << ", ";
        }
        cout << endl;
        return cur;
    }
};
*/
/* // can be optimized to O(1) space
class Solution {
public:
    int rob(vector<int>& nums) {
        int result = 0;
        vector<int> dp(nums);
        for(int i = 0; i < nums.size();i++){
            if(i>1){
                dp[i] += max(dp[i-2],i>2?dp[i-3]:0);
            }
            result = max(result,dp[i]);
        }
        return result;
    }
};
*/
