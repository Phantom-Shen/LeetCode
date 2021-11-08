//
//      b   b   b   a   b 
//  b   1
//  b   2   1
//  b   3   2   1
//  a   3   2   1   1
//  b   4   3   3   1   1
//  
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            dp[i][i] = 1;
            for(int j = i-1; j >= 0; j--){  // after reach ith element, go backward to check palindrome  
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = 2 + dp[i-1][j+1];
                }
                else{
                    // an example to explain here: "bbbab"
                    // if now i is at 'a'
                    // dp[i-1][j] is the number of palindrome that substring [j,i-1] have
                    // dp[i-1][j] is the numebr xx xxxxxxxxxx xxxx xxxxxxxxx [j+1,i] xxxx
                    // if j now is at 0, which is the first 'b'
                    // so we are choosing between 'bbb' and 'bba', and see which has more palindrome
                    // Both values are calculated in previous steps, so that's why it's DP
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j+1]);
                }
            }
        }
        return dp[n-1][0];
    }
}
