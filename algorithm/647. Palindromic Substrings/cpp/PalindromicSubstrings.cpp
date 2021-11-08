class Solution {
public:
    int countSubstrings(string s) {
        int n = s.size(), result = 0;
        vector<vector<bool>> dp(n,vector<bool>(n));
        for(int i = 0; i < n; i++){
            for(int j = i; j >= 0; j--){
                if(s[i]==s[j]){
                    if(j >= i-1 || dp[i-1][j+1]){
                        dp[i][j] = true;
                        result++;
                    }
                }
            }
        }
        return result;
    }
};
