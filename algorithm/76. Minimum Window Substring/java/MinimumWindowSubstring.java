// can be improved by checking if current sliding window is larger than current max-length window
// if it is larger, then there's no need for us to go further with this window since it can never lead to a better result;
// we only look for windows that are smaller than current result
class Solution {
    public String minWindow(String s, String t) {
        int[] freqt = new int[256];
        int[] freqs = new int[256];
        for(int i = 0; i < t.length(); i++){
            freqt[t.charAt(i)] += 1;
        }
        int l = 0, r = 0, maxl = 0, maxr = s.length()+1;
        while(r<s.length()){
            while(r<s.length() && !isValid(freqs, freqt)){
                freqs[s.charAt(r)] += 1;
                r++;
            }
            while(l<r && isValid(freqs, freqt)){
                if(r-l < maxr-maxl){
                    maxr = r;
                    maxl = l;
                }
                freqs[s.charAt(l)] -= 1;
                l++;
            }
        }
        if(maxr == s.length()+1) return "";
        return s.substring(maxl,maxr);
    }
    
    private boolean isValid(int[] freqs, int[] freqt){
        for(int i = 0; i < freqt.length; i++){
            if(freqt[i]==0) continue;
            if(freqs[i]<freqt[i]) return false;
        }
        return true;
    }
}
