class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size();
        vector<int> dp;
        for(int i = 0; i < n; i++){
            if(i == 0 || dp.back() < nums[i]){
                dp.push_back(nums[i]);
            } 
            else{
                vector<int>::iterator it = lower_bound(dp.begin(),dp.end(),nums[i]);
                *it = nums[i];
            }
        }
        return dp.size();
    }
};
/*
class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size();
        vector<int> dp;
        for(int i = 0; i < n; i++){
            if(i == 0 || dp.back() < nums[i]){
                dp.push_back(nums[i]);
            }
            else{
                auto it = lower_bound(dp.begin(), dp.end(), nums[i]);
                *it = nums[i];
            }
        }
        return dp.size();
    }
};
*/
/*
// O(nlogn) O(n)
class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size(), result = 0;
        vector<int> dp;
        for(int i = 0; i < n; i++){
            if(i==0||nums[i] > dp.back())
                dp.push_back(nums[i]);
            else{
                auto it = lower_bound(dp.begin(),dp.end(),nums[i]);
                *it = nums[i];
            }
        }
        return dp.size();
    }
};
*/
/* // O(n^2) O(n)
class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size(), result = 0;
        vector<int> dp(n,1);
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]) 
                    dp[i] = max(dp[i], dp[j]+1); // current len = the longest sub before i that nums[i] < nums[j]
            }
        }
        
        for(int i = 0; i < n; i++){
            result = max(result, dp[i]);
        }
        return result;
    }
};
*/
