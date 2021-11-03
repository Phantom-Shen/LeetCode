class MedianFinder {
    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;
    
    public MedianFinder() {
        right = new PriorityQueue();  // min heap
        left = new PriorityQueue(Collections.reverseOrder());  // max heap
    }
    
    public void addNum(int num) {
        // we must make sure all the elements in right are bigger than those in left
        if(left.size() == right.size()+1){
            left.add(num);
            right.add(left.poll());
            // now left.size() == right.size()
        }
        else{
            right.add(num);
            left.add(right.poll());
            // now left.size() > right.size()
        }
    }
    
    public double findMedian() {
        if(left.size()==right.size()){
            return (left.peek()+right.peek())/2.0;
        }
        return left.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
