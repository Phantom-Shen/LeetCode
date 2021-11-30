class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int row = matrix.length, col = matrix[0].length, result = 0;
        int[] rows = new int[col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j]=='1'){
                    rows[j] += 1;
                }
                else{
                    rows[j] = 0;
                }
            }
            result = Math.max(result, rec(rows));
        }
        return result;
    }
    
    // 84. Largest Rectangle in Histogram
    private int rec(int[] row){
        int n = row.length, result = 0;
        Deque<Integer> stack = new ArrayDeque();
        stack.addLast(-1);
        for(int i = 0; i < n; i++){
            while(stack.peekLast()!=-1 && row[i]<row[stack.peekLast()]){
                int cur = stack.pollLast();
                result = Math.max(result, (i-1-stack.peekLast())*row[cur]);
            }
            stack.addLast(i);
        }
        while(stack.peekLast()!=-1){
            int cur = stack.pollLast();
            result = Math.max(result, (n-1-stack.peekLast())*row[cur]);
        }
        return result;
    }
}
