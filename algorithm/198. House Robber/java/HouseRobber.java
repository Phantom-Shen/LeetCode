class Solution {
    public int rob(int[] nums) {
        int cur = 0, prev = 0, temp = 0;
        for(int i = 0; i < nums.length; i++){
            temp = Math.max(cur, nums[i] + prev);
            prev = cur;
            cur = temp;
        }
        return cur;
    }
}
