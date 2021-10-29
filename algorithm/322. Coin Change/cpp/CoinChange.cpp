class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        vector<int> dp(amount+1,-1);
        dp[0] = 0;
        for(int i = 0; i < amount+1; i++){
            if(dp[i] == -1) continue;
            for(int j = 0; j < coins.size(); j++){
                if(i-amount+coins[j] <= 0){  // to deal with overflow
                    if(dp[i+coins[j]] == -1)
                        dp[i+coins[j]] = dp[i]+1;
                    else
                        dp[i+coins[j]] = min(dp[i+coins[j]], dp[i] + 1);
                }
            }
        }
        return dp[amount];
    }
};
