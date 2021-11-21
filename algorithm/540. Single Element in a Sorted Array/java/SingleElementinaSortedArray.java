class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length, l = 0, r = n-1, mid;
        if(n==1) return nums[0];
        while(l < r){
            mid = l + (r-l)/2;
            // consider situations when: odd number of elements on the left; even number of elements on the right;
            if( ((mid&1)==0 && nums[mid]==nums[mid+1]) || ((mid&1)==1 && nums[mid]!=nums[mid+1]) ){
                l = mid+1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }
}
