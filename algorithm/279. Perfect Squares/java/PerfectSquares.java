class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for(int i = 0; i < n+1; i++){
            for(int j = 1; i+j*j <= n; j++){
                if(dp[i+j*j] == 0){
                    dp[i+j*j] = dp[i] + 1;
                }
                else{
                    dp[i+j*j] = Math.min(dp[i+j*j], dp[i] + 1);
                }
            }
        }
        return dp[n];
    }
}
