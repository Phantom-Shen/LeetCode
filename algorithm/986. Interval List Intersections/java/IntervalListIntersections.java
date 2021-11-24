class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int n1 = firstList.length, n2 = secondList.length, i1 = 0, i2 = 0;
        List<int[]> result = new ArrayList();
        while(i1<n1 && i2<n2){
            int l = Math.max(firstList[i1][0], secondList[i2][0]);
            int r = Math.min(firstList[i1][1], secondList[i2][1]);
            if(l<=r){
                int[] interval = new int[2];
                interval[0] = l;
                interval[1] = r;
                result.add(interval);
            }
            if(firstList[i1][1] >= secondList[i2][1]){
                i2++;
            }
            else{
                i1++;
            }
        }
        return result.toArray(new int[0][]);
    }
}
