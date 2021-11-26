class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length, l = 0, r = n;
        while(l<r){
            int mid = l + (r-l)/2;
            if(target <= nums[mid]){
                r = mid;
            }
            else{
                l = mid+1;
            }
        }
        return l;
    }
}
