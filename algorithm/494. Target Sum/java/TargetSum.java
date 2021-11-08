// Space complexity can be improved, since we are only fetching dp[i][] nad dp[i+1]
// some concept is similar to Coin change
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length, sum = 0;
        for(int num:nums) sum += num;
        // if target is bigger than sum (sum when all symbols are '+') or target is smaller than -sum (sum when all symbols are '-')
        // there's no way we can get a combination that sum to target
        if(target > sum || target < -sum) return 0;
        
        int[][] dp = new int[n][2*sum+1];
        // init condition
        dp[0][sum+nums[0]] = 1;
        dp[0][sum-nums[0]] += 1; // nums[0] could be 0 so, should use += here
        
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < 2*sum+1; j++){
                if(dp[i][j] > 0){
                    dp[i+1][j+nums[i+1]] += dp[i][j];
                    dp[i+1][j-nums[i+1]] += dp[i][j];
                }
            }
        }
        return dp[n-1][sum+target];
    }
}
