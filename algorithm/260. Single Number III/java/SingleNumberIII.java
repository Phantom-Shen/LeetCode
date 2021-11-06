class Solution {
    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        int x = 0;
        for(int num:nums){
            x ^= num;
        }
        // now x equals the XOR of two single number
        int RSB = x&-x; // this gets the rightmost set bit
        int temp = 0;
        for(int num:nums){
            if((RSB&num) == RSB) temp^=num;
        }
        result[0] = temp;
        result[1] = x^temp;
        return result;
    }
}
