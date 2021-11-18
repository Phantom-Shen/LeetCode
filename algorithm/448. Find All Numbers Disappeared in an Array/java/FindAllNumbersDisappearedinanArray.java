class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList();
        for(int i = 0; i < n;){
            if(nums[i] == i+1||nums[nums[i]-1] == nums[i]){
                i++;
            }
            else{
                // swap(nums[i], nums[nums[i]-1])
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        for(int i = 0; i < n; i++){
            if(nums[i]!=i+1){
                result.add(i+1);
            }
        }
        return result;
    }
}
