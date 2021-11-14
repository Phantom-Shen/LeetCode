class CombinationIterator {
    private String str;
    private int length;
    private List<Integer> comb;
    private boolean nextExist;
    public CombinationIterator(String characters, int combinationLength) {
        str = new String(characters);
        length = combinationLength;
        comb = new ArrayList();
        // prepare the first combination in the way of recording index
        for(int i = 0; i < length; i++){
            comb.add(i);
        }
        nextExist = true;
    }
    
    public String next() {
        if(!nextExist) return "Not Exist"; 
        // fetch current combination
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < comb.size(); i++){
            result.append(str.charAt(comb.get(i)));
        }
        // go to next combination and update comb
        for(int i = 0; i < length; i++){
            if(comb.get(length-1-i) == str.length()-1-i) {
                if(i==length-1) nextExist = false;
                continue;
            }
            else{
                comb.set(length-1-i, comb.get(length-1-i)+1);
                for(int j = 1; j <= i; j++){
                    comb.set(length-1-i+j, comb.get(length-1-i+j-1)+1);
                }
                break;
            }
        }
        // return result
        return result.toString();
    }
    
    public boolean hasNext() {
        return nextExist;
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
