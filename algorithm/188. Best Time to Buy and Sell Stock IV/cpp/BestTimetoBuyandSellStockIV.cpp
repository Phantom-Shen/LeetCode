class Solution {
public:
    int maxProfit(int k, vector<int>& prices) {
        int n = prices.size();
        if(n < 2) return 0;
        vector<vector<vector<int>>> dp(2,vector<vector<int>>(k+1, vector<int>(n)));
        for(int i = 0; i < k; i++){
            dp[1][i][0] = -prices[0];
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < k+1; j++){
                if(j!=0) dp[0][j][i] = max(dp[0][j][i-1], dp[1][j-1][i-1]+prices[i]);
                dp[1][j][i] = max(dp[1][j][i-1], dp[0][j][i-1]-prices[i]);
            }
        }
        return dp[0][k][n-1];
    }
};
/*
class Solution {
public:
    int maxProfit(int k, vector<int>& prices) {
        int n = prices.size();
        if(n < 1) return 0;
        vector<vector<vector<int>>> dp(2,vector<vector<int>>(k+1, vector<int>(n)));
        for(int i = 0; i < k; i++){
            dp[1][i][0] = -prices[0];
        }
        for(int i = 1; i < n; i++){
            for(int j = 0; j < k+1; j++){
                if(j!=0) dp[0][j][i] = max(dp[0][j][i-1], dp[1][j-1][i-1]+prices[i]);
                dp[1][j][i] = max(dp[1][j][i-1], dp[0][j][i-1]-prices[i]);
            }
        }
        return dp[0][k][n-1];
    }
};
*/
