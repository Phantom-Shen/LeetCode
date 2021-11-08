class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n+1-k];
        Deque<Integer> deck = new ArrayDeque();
        for(int i = 0; i < n; i++){
            // maintain deck by ensuring front of the deck is max
            while(!deck.isEmpty() && deck.peekFirst() < i+1-k) deck.pollFirst();
            while(!deck.isEmpty() && nums[i] > nums[deck.peekLast()]) deck.pollLast();
            // put on deck
            deck.addLast(i);
            // update result
            if(i+1>=k) result[i+1-k] = nums[deck.peekFirst()];
        }
        return result;
    }
}
/*
// Can be improved!!!!!!!
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n+1-k];
        // use a hash mpa to record how many times we need to delete the element, which we should have deleted in previous step
        Map<Integer, Integer> del = new HashMap(); // <key, value> = <num, number of times we need to delete num>
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        for(int i = 0; i < n; i++){
            pq.add(nums[i]);
            if(pq.size() >= k){
                // update max
                result[i+1-k] = pq.peek();
                // put the earliest element of the window into del, meaning that we should remove it from the window, but only doing it later
                del.put(nums[i+1-k], 1 + del.getOrDefault(nums[i+1-k], 0));
            }
            // if current max is in del, we should remove it from pq
            // keep doing this until new max is not in del
            while(del.getOrDefault(pq.peek(), 0) > 0){
                del.put(pq.peek(), del.get(pq.peek())-1);
                pq.poll();
            }
        }
        return result;
    }
}
*/
