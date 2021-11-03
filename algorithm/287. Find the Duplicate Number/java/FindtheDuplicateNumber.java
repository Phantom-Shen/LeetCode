// since the correct array should be [1,n]
// we could use it as a hashtable
// if there's a number that is not at where it belongs to, that number is the duplicate
class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for(int i = 0 ; i < n;){
            if(nums[i] == i+1){
                i++;
            }
            else{
                if(nums[nums[i]-1]==nums[i]){
                    return nums[i];
                }
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        return 0;
    }
}
