class TrieNode{
    public boolean isWord;
    public TrieNode[] next = new TrieNode[26];
    TrieNode(){}
}
class Trie {
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();    
    }
    
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            if(cur.next[word.charAt(i)-'a']==null){
                cur.next[word.charAt(i)-'a'] = new TrieNode();
            }
            cur = cur.next[word.charAt(i)-'a'];
        }
        cur.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            if(cur.next[word.charAt(i)-'a']==null){
                return false;
            }
            cur=cur.next[word.charAt(i)-'a'];
        }
        return cur.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0; i < prefix.length(); i++){
            if(cur.next[prefix.charAt(i)-'a']==null){
                return false;
            }
            cur = cur.next[prefix.charAt(i)-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
