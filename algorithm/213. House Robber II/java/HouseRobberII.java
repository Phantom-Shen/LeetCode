class Solution {
    public int rob(int[] nums) {
        if(nums.length < 2) return nums[0];
        return Math.max(robber(nums, 0, nums.length-1), robber(nums, 1, nums.length));
    }
    
    private int robber(int[] nums, int l, int r){
        int cur = 0, prev = 0, temp = 0;
        for(int i = l; i < r; i++){
            temp = Math.max(cur, nums[i]+prev);
            prev = cur;
            cur = temp;
        }
        return cur;
    }
}
