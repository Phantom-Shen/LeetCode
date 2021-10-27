class Solution {
    public boolean canArrange(int[] arr, int k) {
        int n = arr.length;
        int[] mp = new int[k];
        for(int i = 0; i < n; i++){
            int rem = arr[i]%k;
            if(rem < 0) mp[rem+k] += 1;
            else mp[rem] += 1;
        }
        //for(int i : mp) System.out.print(i+", ");
        //System.out.println();
        for(int i = 0; i < k/2+1; i++){
            if((i==k-i || i==0)&&mp[i]%2==1) return false;
            if(mp[i%k] != mp[(k-i)%k]) return false;
        }
        return true;
    }
}
