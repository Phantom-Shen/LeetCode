class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length, prod = 1;
        int[] result = new int[n];
        for(int i = 0; i < n; i++){
            result[i] = 1;
            result[i] *= prod;
            prod *= nums[i];
        }
        prod = 1;
        for(int i = n-1; i >= 0; i--){
            result[i] *= prod;
            prod *= nums[i];
        }
        return result;
    }
}
