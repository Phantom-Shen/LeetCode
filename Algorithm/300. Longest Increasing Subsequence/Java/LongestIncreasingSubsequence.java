class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, size = 0;
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            int l = 0, r = size;
            while(l < r){
                int mid = l + ((r-l)>>1);
                if(nums[i] > dp[mid]){
                    l = mid+1;
                }
                else{
                    r = mid;
                }
            }
            dp[l] = nums[i];
            if(l == size) size++;
        }
        return size;
    }
}
/*
// from c++ solution
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, size = 0;
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            if(i == 0 || nums[i] > dp[size-1]){
                dp[size] = nums[i];
                size++;
            }
            else{
                // bin search
                int l = 0, r = size;
                while(l < r){
                    int mid = l + ((r-l)>>1);
                    if(nums[i] > dp[mid]){
                        l = mid+1;
                    }
                    else{
                        r = mid;
                    }
                }
                dp[l] = nums[i];
            }
        }
        return size;
    }
}
*/
