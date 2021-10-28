// notice the initial condition when i == 0 || j == 0, dp[i][j] = i+j;
// becuase it means the number of  operations we need for alligning the words
// e.g. word1 = "horse", word2 = "ros"
// While comparing two words,
// if we allign the word like:
//      h   o   r   s   e
//      r   o   s
// then, dp[i][j] = i + j = 0 + 0 = 0;
// since both words start from index 0;
//
// However if we allign the word like:
//      h   o   r   s   e
//          r   o   s
// Since word2 start from index 1,
// Then, we can regard it as that we have already made one deletion operation on 'h' in word1
// so dp[i][j] = i + j = 0 + 1 = 1;
// 
// etc.
class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        int[][] dp = new int[n1+1][n2+1];
        for(int i = 0; i < n1 + 1; i++){
            for(int j = 0; j < n2 + 1; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = i+j;
                }
                else if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                }
            }
        }
        return dp[n1][n2];
    }
}
