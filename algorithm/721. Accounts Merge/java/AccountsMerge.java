// Use union find algorithm/data structure
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        int[] parent = new int[accounts.size()];
        Map<String, Integer> mp = new HashMap();
        
        for(int i = 0; i < accounts.size(); i++){
            parent[i] = i;
            for(int j = 1; j < accounts.get(i).size(); j++){
                String email = accounts.get(i).get(j);
                if(mp.containsKey(email)){
                    parent[find(parent, i)] = find(parent, mp.get(email));
                }
                else{
                    mp.put(email, i);
                }
            }
        }
        
        Map<Integer, List<String>> unionMap = new HashMap();
        for(String email:mp.keySet()){
            int pa = find(parent, mp.get(email));
            unionMap.putIfAbsent(pa, new ArrayList());
            unionMap.get(pa).add(email);
        }
        
        List<List<String>> result = new ArrayList();
        for(int pa:unionMap.keySet()){
            List<String> emails = unionMap.get(pa);
            Collections.sort(emails);
            emails.add(0, accounts.get(pa).get(0));
            result.add(emails);
        }
        
        return result;
    }
    
    private int find(int[] parent, int x){
        if(parent[x] != x){
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}
