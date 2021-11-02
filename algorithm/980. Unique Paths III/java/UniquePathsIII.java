// haven't checked if there's a more optimal solution
class Solution {
    public int uniquePathsIII(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[] result = new int[1];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1) {
                    grid[i][j] = 0;
                    recur(grid, i, j, result);
                }
            }
        }
        return result[0];
    }
    
    private void recur(int[][] grid, int i, int j, int[] result){
        //System.out.println(i+", "+j);
        int row = grid.length, col = grid[0].length;
        if(grid[i][j] == 2){
            for(int l = 0; l < row; l++){
                for(int r = 0; r < col; r++){
                    if(grid[l][r] == 0) return;
                }
            }
            result[0] += 1;
        }
        else if(grid[i][j] == 0){
            grid[i][j] = 1;
            if(i+1<row && grid[i+1][j]!=1 && grid[i+1][j]!=-1) recur(grid, i+1, j, result);
            if(i-1>=0 && grid[i-1][j]!=1 && grid[i-1][j]!=-1) recur(grid, i-1, j, result);
            if(j+1<col && grid[i][j+1]!=1 && grid[i][j+1]!=-1) recur(grid, i, j+1, result);
            if(j-1>=0 && grid[i][j-1]!=1 && grid[i][j-1]!=-1) recur(grid, i, j-1, result);
            grid[i][j] = 0;
        }
        
    }
}
