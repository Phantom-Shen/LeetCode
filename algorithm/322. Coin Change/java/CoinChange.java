class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for(int i = 1; i < amount+1; i++){
            dp[i] = -1;
        }
        for(int i = 0;i < amount+1; i++){
            if(dp[i] == -1) continue;
            for(int coin: coins){
                if(i-amount+coin <= 0){ // avoid overflow
                    if(dp[i+coin] == -1) dp[i+coin] = 1 + dp[i];
                    else dp[i+coin] = Math.min(dp[i+coin], 1 + dp[i]);     
                }
            }
        }
        return dp[amount];
    }
}
