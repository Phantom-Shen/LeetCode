class TrieNode{
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];
    TrieNode(){}
}

class StreamChecker {
    private TrieNode root;
    private StringBuilder word;
    public StreamChecker(String[] words) {
        root = new TrieNode();
        word = new StringBuilder();
        buildTrie(words);
    }
    
    public boolean query(char letter) {
        word.append(letter);
        TrieNode cur = root;
        int i;
        for(i = word.length() - 1; i >= 0 && cur != null; i--){
            int c = word.charAt(i);
            cur = cur.children[c-'a'];
            if(cur != null && cur.isWord) return true;
        }
        return false;
    }
    
    private void buildTrie(String[] words){
        int n = words.length;
        for(int i = 0; i < n; i++){
            TrieNode cur = root;
            for(int j = words[i].length() - 1; j >= 0; j--){
                char c = words[i].charAt(j);
                if(cur.children[c-'a'] == null){
                    cur.children[c-'a'] = new TrieNode();
                }
                cur = cur.children[c-'a'];
            }
            cur.isWord = true;
        }
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
