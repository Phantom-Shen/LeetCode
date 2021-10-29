// very similar Coin change. 
// Looks like we only flipped the inner loop with the outer loop. 
// But the reason behind it is very important
// Understand with this post: https://leetcode.com/problems/coin-change-2/discuss/176706/Beginner-Mistake%3A-Why-an-inner-loop-for-coins-doensn't-work-Java-Soln
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int coin:coins){
            for(int i = 0; i < amount+1; i++){
                if(i-coin >= 0){
                    dp[i] += dp[i-coin];
                }
            }
        }
        return dp[amount];
    }
}
