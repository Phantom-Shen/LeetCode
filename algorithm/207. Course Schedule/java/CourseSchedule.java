class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // convert to adjacency list
        List<Integer>[] graph = new ArrayList[numCourses];
        // Initialization
        for(int i = 0; i < numCourses; i++) graph[i] = new ArrayList();
        // Build Graph
        for(int i = 0; i < prerequisites.length; i++){
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        
        boolean[] visited = new boolean[numCourses];
        boolean[] done = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(done[i]) continue;
            if(!recur(graph, visited, done, i)) return false;
            done[i] = true;
        }
        return true;
    }
    
    private boolean recur(List<Integer>[] graph, boolean[] visited, boolean[] done, int curCourse){
        if(visited[curCourse]) return false;
        visited[curCourse] = true;
        for(int course:graph[curCourse]){
            if(!done[course] && !recur(graph,visited,done,course)){
                return false;
            }
            done[course] = true;
        }
        visited[curCourse] = false;
        return true;
    }
}
