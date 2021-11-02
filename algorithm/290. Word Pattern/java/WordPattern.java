class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> p2s = new HashMap();
        Map<String, Character> s2p = new HashMap();
        int i = 0, l = 0, r = 0;
        while(i<pattern.length() && r<s.length()){
            if(r+1 == s.length() || s.charAt(r+1) == ' '){
                String curStr = s.substring(l,r+1);
                char curC = pattern.charAt(i);
                //System.out.println(curStr+", "+curC);
                if(s2p.containsKey(curStr)){
                    if(s2p.get(curStr)!=curC) return false;
                }
                if(p2s.containsKey(curC)){
                   if(!p2s.get(curC).equals(curStr)) return false; 
                }
                s2p.put(curStr, curC);
                p2s.put(curC, curStr);
                l = r+2;
                i++;
                r++;
            }
            r++;
        }
        if(i<pattern.length() || r<s.length()) return false;
        return true;
    }
}
