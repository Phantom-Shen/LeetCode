class Solution {
public:
    int integerBreak(int n) {
        if(n==2) return 1;
        if(n==3) return 2;
        vector<int> dp(n+1);
        dp[2] = 2, dp[3] = 3;
        for(int i = 4; i < n+1; i++){
            for(int j = 2; j < (i>>1)+1; j++){
                dp[i] = max(dp[i], dp[j]*dp[i-j]);
            }
        }
        return dp[n];
    }
};
/*
// can be improved to O(n) O(1) or even O(1) O(1) with pure math solution
class Solution {
public:
    int integerBreak(int n) {
        if(n==2) return 1;
        if(n==3) return 2;
        vector<int> dp(n+1);
        dp[2] = 2;
        dp[3] = 3;
        for(int i = 2; i < n+1; i++){
            for(int j = 1; j < i/2 + 1; j++){
                dp[i] = max(dp[i], dp[j]*dp[i-j]);
            }
        }
        return dp[n];
    }
};
*/
/*
class Solution {
public:
    int integerBreak(int n) {
        // since when n == 2 or n == 3, the result is smaller than itself, we just check this two cases at the beginning.
        if(n == 2) return 1;
        if(n == 3) return 2;
        vector<int> dp(n+1);
        dp[2] = 2, dp[3]  = 3;
        for(int i = 4; i < n+1; i++){
            for(int j = 1; j < i/2+1; j++){
                dp[i] = max(dp[i], j*dp[(i-j)]);
            }
        }
        return dp[n];
    }
};
*/
