// we can convert this problem to: if we can find a subset that sum to target
// Since in original goal, we are trying to divide the list into two subsets where sum of both equals to each other
// So, we can find a subset that sum to target where target = total sum of the list / 2
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        // if odd, there's no way we can partition into two subset with equal sum
        if((sum&0x00000001) == 1) return false;
        // Knapsack problem (particularly 0/1 Knapsack)
        int target = sum>>1;
        boolean[][] dp = new boolean[nums.length+1][target+1];
        
        for(int i = 0; i < nums.length+1; i++){
            for(int j = 0; j < target+1; j++){
                if(i==0 && j==0) dp[i][j] = true;
                else if(i==0) dp[i][j] = false;
                else if(j==0) dp[i][j] = true;
                else{
                    if(j-nums[i-1] < 0){ // if we don't have enough capacity to pick up nums[i-1]
                        dp[i][j] = dp[i-1][j];
                    }
                    else{
                        // we can either not pick up nums[i-1] or pick up nums[i-1];
                        dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                    }
                }
            }
        }
        
        return dp[nums.length][target];
    }
}
