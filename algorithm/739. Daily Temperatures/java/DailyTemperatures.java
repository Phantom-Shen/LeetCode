class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        for(int i = n-1, maxi = n-1; i >= 0; i--){
            if(temperatures[i] >= temperatures[maxi]){
                maxi = i;
            }
            else{
                int step = 1;
                while(temperatures[i+step] <= temperatures[i]){
                    step += result[i+step];
                }
                result[i] = step;
            }
        }
        return result;
    }
}
/*
// We can improve the space complexity by using the calculated result for searching next warmer temp, in stead of using a stack which uses too much space
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Deque<Integer> stack = new ArrayDeque();
        int[] result = new int[n];
        for(int i = n-1; i>=0; i--){
            if(i==n-1){
                stack.addLast(i);
                result[i] = 0;
                continue;
            }
            while(!stack.isEmpty() && temperatures[i]>=temperatures[stack.peekLast()]){
               stack.pollLast();
            }
            if(stack.isEmpty()){
                result[i] = 0;
            }
            else{
                result[i] = stack.peekLast()-i;
            }
            stack.addLast(i);
        }
        return result;
    }
}
*/
