// monotonic stack
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, result = 0;
        Deque<Integer> stack = new ArrayDeque();
        stack.addLast(-1);
        for(int i = 0; i < n; i++){
            while(stack.peekLast()!=-1 && heights[i]<heights[stack.peekLast()]){
                int cur = stack.pollLast();
                result = Math.max(result, (i-1-stack.peekLast())*heights[cur]);
            }
            stack.addLast(i);
        }
        while(stack.peekLast()!=-1){
            int cur = stack.pollLast();
            result = Math.max(result, (n-1-stack.peekLast())*heights[cur]);
        }
        return result;
    }
}
