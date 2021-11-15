class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums); 
        List<Integer> result = new ArrayList();
        int[] last = new int[n]; // use last[] to record the previous num that has 1 less count, so we can use last[] to get the result
        int[] count = new int[n];
        Arrays.fill(last, -1);
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i]%nums[j] == 0){
                    if(1+count[j] > count[i]){
                        count[i] = 1+count[j];
                        last[i] = j;
                    }
                }
            }
        }
        //System.out.println(Arrays.toString(count));
        int longest = 0;
        for(int i = 0; i < n; i++){
            if(count[i] > count[longest]){
                longest = i;
            }
        }
        //System.out.println(longest);
        while(longest!=-1){
            result.add(nums[longest]);
            longest = last[longest];
        }
        
        return result;
    }
}
