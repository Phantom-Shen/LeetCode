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

// solution using hashmap by hobiter
/*
public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            int rem = n % k;
            if (rem < 0) rem += k;
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (key == k - key || key == 0) {if (map.get(key) % 2 != 0) return false;}
            else if (!map.get(key).equals(map.getOrDefault(k - key, 0))) return false;  // can not use == here, Integer boxed;
        }
        return true;
}
*/
