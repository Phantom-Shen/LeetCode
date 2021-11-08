class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        // 0 node tree and 1 node tree both have 1 unique combination
        dp[0] = dp[1] = 1;
        for(int i = 2; i < n+1; i++){
            for(int j = 0; j < i; j++){
                dp[i] += dp[j]*dp[i-1-j];
            }
        }
        return dp[n];
    }
}
