// The solution is similar to 518. Coin Change 2
// but they cannot use interchangably
// should differenciate both solution
// better to understand it with both problem
class Solution {
    public int combinationSum4(int[] nums, int target) {
       int n = nums.length;
       int[] dp = new int[target+1];
       dp[0] = 1; 
       for(int i = 0; i < target+1; i++){
           if(dp[i] == 0) continue; 
           for(int num:nums){
               if(i-target+num<=0){
                   dp[i+num] += dp[i];
               }
           }
       }
       return dp[target];
    }
}
