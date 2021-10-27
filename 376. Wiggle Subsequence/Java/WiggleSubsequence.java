// the space complexity can be improved for the method beneath
// using concept of state machine
// dp[0] represents current difference is negative
// dp[1] represents current difference is positive
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[2][n];
        dp[0][0] = 1;
        dp[1][0] = 1;
        for(int i = 1; i < n; i++){
            if(nums[i]-nums[i-1] == 0){
                dp[0][i] = dp[0][i-1];
                dp[1][i] = dp[1][i-1];
            }
            else if(nums[i]-nums[i-1] > 0){
                //dp[0][i] = dp[1][i-1];
                dp[1][i] = Math.max(dp[1][i-1], dp[0][i-1] + 1);
            }
            else{
                dp[0][i] = Math.max(dp[0][i-1], dp[1][i-1] + 1);
                //dp[1][i] = dp[1][i-1];
            }
        }
        return Math.max(dp[0][n-1], dp[1][n-1]);
    }
}
