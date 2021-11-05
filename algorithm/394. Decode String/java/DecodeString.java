class Solution {
    public String decodeString(String s) {
        //System.out.println("input: "+s);
        Deque<Boolean> stack = new ArrayDeque(); // false for '[', true for ']'
        int n = 0, l = 0, r = 0;
        StringBuilder str = new StringBuilder();
        while(r < s.length()){
            // use a while loop to capture a value that has more than one digit.
            while(s.charAt(r)>='0' && s.charAt(r)<='9' && stack.isEmpty()){ 
                n++;
                r++;
            }
            if(s.charAt(r)=='['){
                if(stack.isEmpty()){
                    str.append(s.substring(l,r-n));
                    l = r;
                }
                stack.addLast(false);
            }
            else if(s.charAt(r)==']'){
                // This only works if the input is guaranteed to have valid bracket arrangement.
                stack.pollLast();
                if(stack.isEmpty()){
                    String decoded = decodeString(s.substring(l+1,r));
                    int num = Integer.parseInt(s.substring(l-n,l));
                    for(int i = 0; i < num; i++) str.append(decoded);
                    l = r+1;
                    n = 0;
                }
            }
            r++;
        }
        if(l < r){
            str.append(s.substring(l,r));
        }
        //System.out.println("output: "+str.toString());
        return str.toString();
    }
}
