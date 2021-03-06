class Solution {
public:
    int longestPalindromeSubseq(string s) {
        int n = s.size();
        vector<vector<int>> dp(n, vector<int>(n));
        for(int i = 0 ; i < n ; i++){
            dp[i][i] = 1;
            for(int j = i-1; j >= 0; j--){
                if(s[i] == s[j]){
                    dp[i][j] = 2 + dp[i-1][j+1];
                }
                else{
                    dp[i][j] = max(dp[i][j+1], dp[i-1][j]);
                }
            }
        }
        return dp[n-1][0];
    }
};
