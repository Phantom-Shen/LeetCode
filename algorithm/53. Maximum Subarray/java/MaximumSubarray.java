// Kadane's algorithm
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length, result = nums[0], curMax = 0;
        for(int i = 0;i < n; i++){
            curMax = Math.max(nums[i], curMax+nums[i]);
            result = Math.max(result, curMax);
        }
        return result;
    }
}
