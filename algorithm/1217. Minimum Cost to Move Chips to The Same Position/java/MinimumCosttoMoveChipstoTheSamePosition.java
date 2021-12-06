class Solution {
    public int minCostToMoveChips(int[] position) {
        int n = position.length, odd = 0, even = 0;
        for(int i = 0; i < n; i++){
            if((position[i] & 1) == 1){ // odd
                odd++;
            }
            else{
                even++;
            }
        }
        return Math.min(odd, even);
    }
}
