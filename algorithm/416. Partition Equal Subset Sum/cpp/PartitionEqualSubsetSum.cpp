class Solution {
public:
    bool canPartition(vector<int>& nums) {
        int n = nums.size(), sum = 0;
        for(int num:nums) sum+=num;
        if((sum&1) == 1) return false;
        
        int target = sum>>1;
        vector<vector<bool>> dp(n+1, vector<bool>(target+1));
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= target; j++){
                if(i==0 && j==0) dp[i][j] = true;
                else if(i==0) dp[i][j] = false;
                else if(j==0) dp[i][j] = true;
                else{
                    if(j-nums[i-1] < 0){
                        dp[i][j] = dp[i-1][j];
                    }
                    else{
                        dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                    }
                }
            }
        }
        return dp[n][target];
    }
};
