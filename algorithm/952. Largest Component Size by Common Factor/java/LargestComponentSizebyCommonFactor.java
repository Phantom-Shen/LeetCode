class UnionFindSet{
    private int[] parents;
    public UnionFindSet(int n) {
        parents = new int[n];
        for(int i = 0; i < n; i++){
            parents[i] = i;
        }
    }
    
    public int find(int x){
        if(x!=parents[x]){
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }
    
    public void union(int x, int y){
        parents[find(x)] = parents[find(y)];
    }
}
class Solution {
    public int largestComponentSize(int[] nums) {
        int n = nums.length, maxNum = nums[0];
        for(int i = 0; i < n; i++){
            maxNum = Math.max(maxNum, nums[i]);
        }
        
        UnionFindSet ufs = new UnionFindSet(maxNum+1);
        for(int i = 0; i < n; i++){
            for(int j = 2; j*j <= nums[i]; j++){
                if(nums[i]%j == 0){ // if j is a factor of nums[i]
                    ufs.union(nums[i], j); // merge nums[i] to j
                    ufs.union(nums[i], nums[i]/j); // also merge the divisor
                }
            }
        }
        
        Map<Integer, Integer> mp = new HashMap(); // record the frequecy
        int result = 1;
        for(int i = 0; i < n; i++){
            int parent = ufs.find(nums[i]);
            mp.put(parent, mp.getOrDefault(parent, 0)+1);
            result = Math.max(result, mp.get(parent));
        }
        return result;
    }
}
