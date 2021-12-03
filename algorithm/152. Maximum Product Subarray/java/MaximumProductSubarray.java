class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length, result = nums[0], left = 1, right = 1;
        for(int i = 0; i < n; i++){
            left *= nums[i];
            right *= nums[n-1-i];
            result = Math.max(result, Math.max(left, right));
            if(left == 0) left = 1;
            if(right == 0) right = 1;
        }
        return result;
    }
}
