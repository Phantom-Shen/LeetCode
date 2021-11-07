// space complexity can be improved, since each time we only need dp[i][] and dp[i-1][] (two rows)
// we can think it as that i is the right most char of currrent palindrome and j is the left most char
// if the substring in the middle is a palindrome and left most char equal right most char, then current substring is a palindrome
class Solution {
    public int countSubstrings(String s) {
        int n = s.length(), result = 0;
        boolean[][] dp = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            dp[i][i] = true;
            for(int j = i; j >= 0; j--){
                if(s.charAt(i)==s.charAt(j)){
                    if(j>=i-1||dp[i-1][j+1]){ // dp[i-1][j+1] is the substring from s[j+1] to s[i-1] which is substring in the middle of s[j] and s[i]
                        dp[i][j] = true;
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
/*
// Maybe simplify the structure a bit more
class Solution {
    public int countSubstrings(String s) {
        int n = s.length(), result = n; // initially we know every single char count 1 palindrome
        boolean[][] dp = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            dp[i][i] = true;
            for(int j = i-1; j >= 0; j--){
                if(s.charAt(i)==s.charAt(j)){
                    if(j==i-1||dp[i-1][j+1]){
                        dp[i][j] = true;
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
*/
