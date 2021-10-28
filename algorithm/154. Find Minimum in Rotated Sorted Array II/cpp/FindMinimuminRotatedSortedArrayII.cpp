// inspired by jianchao-li's solution
class Solution {
public:
    int findMin(vector<int>& nums) {
        int n = nums.size(), l = 0, r = n-1;
        // check if nums is rotated
        if(nums[0] < nums[n-1]) return nums[0];
        // notice: [1,1,1,1,1,1,1] and other similar cases
        
        while(l < r && nums[l] > nums[r]){ // must make sure nums[l] > nums[a], otherwise we can only do linear search
            int mid = l + (r-l)/2;
            if(mid > 0 && nums[mid-1] > nums[mid]) return nums[mid];
            else if(nums[l] <= nums[mid]){
                l = mid+1;
            }
            else{
                r = mid;
            }
        }
        
        int result = nums[l];
        while(l < r){
            result = min(result, nums[l]);
            l++;
        }
        return result;
    }
};
