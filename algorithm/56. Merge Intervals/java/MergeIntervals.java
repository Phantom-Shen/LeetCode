class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->{
            return a[0]-b[0];
        });
        int n = intervals.length;
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for(int i = 1; i < n; i++){
            int[] cur = result.get(result.size()-1);
            if(cur[1] >= intervals[i][0]){
                cur[0] = Math.min(cur[0], intervals[i][0]);
                cur[1] = Math.max(cur[1], intervals[i][1]);
            }
            else{
                result.add(intervals[i]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
