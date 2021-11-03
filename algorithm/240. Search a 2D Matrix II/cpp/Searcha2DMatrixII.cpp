// you can tree the top-right entry as a root for a BST, since everything on the left are smaller than it and everything beneath are bigger than it.
// Similar for bottom-left entry.
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int row = matrix.size(), col = matrix[0].size(), r = 0, c = col-1;
        while(r<row && c>=0){
            if(target == matrix[r][c]) return true;
            else if(target < matrix[r][c]){
                c--;
            }
            else{
                r++;
            }
        }
        return false;
    }
};
/*
// can be optimized
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int row = matrix.size(), col = matrix[0].size(), lrow = -1, rrow = -1, lcol = -1, rcol = -1;
        for(int i = 0; i < row; i++){ // checking rows 
            if(target >= matrix[i][0] && target <= matrix[i][col-1]){
                if(lrow==-1) lrow = i, rrow = i;
                else rrow = i;
            }
        }
        for(int i = 0; i < col; i++){
            if(target >= matrix[0][i] && target <= matrix[row-1][i]){
                if(lcol==-1) lcol = i, rcol = i;
                else rcol = i;
            }
        }
        // optimize
        if(lrow==-1||lcol==-1||rrow==-1||rcol==-1) return false;
        for(int i = lrow; i <= rrow; i++){
            for(int j = lcol; j <= rcol; j++){
                if(matrix[i][j] == target) return true;
            }
        }
        return false;
    }
};
*/
/*// cannot handle duplicate target
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        //cout << "new test" << endl;
        return recur(matrix,target,0,0,matrix.size()-1,matrix[0].size()-1);
    }
private:
    bool recur(vector<vector<int>>& matrix, int target, int li, int lj, int ri, int rj){
        if(li==ri&&lj==rj&&target==matrix[li][lj]) return true;
        int lrow = -1, rrow = -1, lcol = -1, rcol = -1;
        for(int i = li; i <= ri; i++){
            if(target >= matrix[i][lj]&&target <= matrix[i][rj]){
                if(lrow == -1) lrow = i, rrow = i;
                else rrow = i;
            }
        }
        for(int i = lj; i <= rj; i++){
            if(target >= matrix[li][i]&&target <= matrix[ri][i]){
                if(lcol == -1) lcol = i, rcol = i;
                else rcol = i;
            }
        }
        //cout << lrow << ", " << lcol << ", " << rrow << ", " << rcol << endl;
        if(lrow==-1||lcol==-1||rrow==-1||rcol==-1) return false;
        if(recur(matrix,target,lrow,lcol,rrow,rcol)) return true;
        return false;
    }
};
*/
/* // trying binSearch, seems failed
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int row = matrix.size(), col = matrix[0].size(), li=0, lj=0, ri = row - 1, rj = col - 1, midi, midj; 
        if(row == 1){ // if there's only one row, just do a normal binSearch
            int l = 0, r = col-1, mid;
            while(l<=r){
                mid = l + (r-l)/2;
                if(matrix[0][mid]==target) return true;
                if(target < matrix[0][mid]) r = mid-1;
                else l = mid+1;
            }
            return false;
        }
        if(col == 1){
            int l = 0, r = row-1, mid;
            while(l<=r){
                mid = l + (r-l)/2;
                if(matrix[mid][0]==target) return true;
                if(target < matrix[mid][0]) r = mid-1;
                else l = mid+1;
            }
            return false;
        }
        while(li<=ri&&lj<=rj){
            midi = li+(ri-li)/2, midj = lj + (rj-lj)/2;
            if(target == matrix[midi][midj]) return true;
            if(midi>0&&midj>0&&target>matrix[midi-1][midj-1]&&target<matrix[midi][midj]){
                // binSearch left to right
                int l = 0, r = midj-1, mid;
                while(l<=r){
                    mid = l + (r-l)/2;
                    if(target == matrix[midi][mid]) return true;
                    if(target < matrix[midi][mid])
                        r = mid-1;
                    else
                        l = mid+1;
                }
                // binSearch up to down
                l = 0, r = midi-1;
                while(l<=r){
                    mid = l + (r-l)/2;
                    if(target == matrix[mid][midj]) return true;
                    if(target < matrix[mid][midj])
                        r = mid-1;
                    else
                        l = mid+1;
                }
                return false;
            }
            if(target < matrix[midi][midj])
                ri = midi-1, rj = midj-1;
            else
                li = midi+1, lj = midj+1;
        }
        return false;
    }
};
*/
