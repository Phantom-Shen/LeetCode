class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size();
        if(n < 2) return nums[0];
        return max(robber(nums,0,n-1), robber(nums,1,n));
    }
private:
    int robber(vector<int>& nums, int l, int r){
        int n = nums.size(), prev = 0, cur = 0, result;
        for(int i = l; i < r; i++){
            result = max(prev+nums[i],cur);
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
        int n = nums.size();
        if(n < 2) return nums[0];
        return max(robber(nums,0,n-1),robber(nums,1,n));
    }
private:
    int robber(vector<int>& nums, int l, int r){
        int cur = 0, prev = 0;
        for(int i = l; i < r; i++){
            int temp = max(prev+nums[i], cur);
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
        int n = nums.size();
        if(n < 2) return nums[0];
        return max(robber(nums,1,n), robber(nums,0,n-1)); // just two "House Robber" problem, but one without 0 and with n-1, another with 0 and without n-1;
    }
private:
    int robber(vector<int>& nums, int l, int r){
        int prev = 0, cur = 0;
        for(int i = l; i < r; i++){
            int temp = max(prev+nums[i], cur);
            prev = cur;
            cur = temp;
        }
        return cur;
    }
};
*/
