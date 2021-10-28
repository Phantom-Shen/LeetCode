class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length, i = n-2;
        while(i>=0 && nums[i] >= nums[i+1]){
            i--;
        }
        if(i >= 0){
            int j = n - 1;
            while(j>=0 && nums[j] <= nums[i]){
                j--;
            }
            swap(nums,i,j);
        } 
        reverse(nums,i+1, n-1);
    }
    private void swap(int[] nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
    
    private void reverse(int[] nums, int l, int r){ //inclusive on right bound
        while(l < r){
            swap(nums,l,r);
            l++;
            r--;
        }
    }
}
