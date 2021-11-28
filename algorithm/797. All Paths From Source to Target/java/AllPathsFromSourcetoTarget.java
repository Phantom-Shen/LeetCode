class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> result = new ArrayList();
        List<Integer> comb = new ArrayList();
        comb.add(0);
        recur(graph, comb, result, 0);
        return result;
    }
    
    private void recur(int[][] graph, List<Integer> comb, List<List<Integer>> result, int cur){
        int n = graph.length;
        if(cur == n-1){
            List<Integer> oneResult = new ArrayList();
            for(int i = 0; i < comb.size(); i++) oneResult.add(comb.get(i));
            result.add(oneResult);
        }
        else{
            for(int i = 0; i < graph[cur].length; i++){
                comb.add(graph[cur][i]);
                recur(graph, comb, result, graph[cur][i]);
                comb.remove(comb.size()-1);
            }
        }
    }
}
