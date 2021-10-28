class Solution {
    public int findMin(int[] nums) {
        int n = nums.length, l = 0, r = n-1;
        while(l < r && nums[l] > nums[r]){
            int mid = l + (r-l)/2;
            if(mid > 0 && nums[mid-1] > nums[mid]) return nums[mid];
            else if(nums[l] <= nums[mid]){
                l = mid + 1;
            }
            else{
                r = mid;
            }
        }
        // Linear search
        int result = nums[l];
        while(l < r){
            result = Math.min(result, nums[l]);
            l++;
        }
        return result;
    }
}
