class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        int n = prerequisites.size();
        vector<vector<int>> graph(numCourses);
        // build graph
        for(int i = 0; i < n; i++){
            graph[prerequisites[i][0]].push_back(prerequisites[i][1]);
        }
        vector<bool> visited(numCourses); // used in each dfs to check if there is a cycle
        vector<bool> done(numCourses);  // record the courses that has been checked
        for(int i = 0; i < numCourses; i++){
            if(done[i]) continue;
            if(!dfs(graph,visited,done,i)) return false;
            done[i] = true;
        }
        return true;
    }
private:
    bool dfs(vector<vector<int>>& graph, vector<bool>& visited, vector<bool>& done, int course){
        if(visited[course]) return false;
        visited[course] = true;
        for(int next:graph[course]){
            if(!done[next]&&!dfs(graph,visited,done,next)) return false;
            done[next] = true;
        }
        visited[course] = false;
        return true;
    }
};
