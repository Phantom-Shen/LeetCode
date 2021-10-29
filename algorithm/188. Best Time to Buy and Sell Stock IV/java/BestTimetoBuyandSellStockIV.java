// DP
// using idea of state machine
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(n < 2) return 0;
        int[][][] dp = new int[2][k+1][n];
        for(int i = 0;  i < k+1; i++){
            dp[1][i][0] = -prices[0];
        }
        for(int i = 1; i < n; i++){
            dp[1][0][i] = Math.max(dp[1][0][i-1], dp[0][0][i-1]-prices[i]);
            for(int j = 1; j < k+1; j++){
                dp[0][j][i] = Math.max(dp[0][j][i-1], dp[1][j-1][i-1]+prices[i]);
                dp[1][j][i] = Math.max(dp[1][j][i-1], dp[0][j][i-1]-prices[i]);
            }
        }
        return dp[0][k][n-1];
    }
}
