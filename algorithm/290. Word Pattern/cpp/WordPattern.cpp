class Solution {
public:
    bool wordPattern(string pattern, string s) {
        int np = pattern.size(), ns = s.size();
        // bijection relation: use two hash table to guarantee symmetric relation.
        // a <-> b  =>  a -> b && b -> a
        unordered_map<char, string> ch2str;
        unordered_map<string, char> str2ch;
        int l = 0, r;
        for(int i = 0 ; i < np; i++){
            if(l>=ns) return false;
            r = l;
            while(r < ns && s[r]!=' ') r++;
            string str = s.substr(l,r-l);
            if(ch2str.find(pattern[i])!=ch2str.end() && ch2str[pattern[i]] != str)
                return false;
            if(str2ch.find(str)!=str2ch.end() && str2ch[str] != pattern[i])
                return false;
            str2ch[str] = pattern[i];
            ch2str[pattern[i]] = str;
            l = r+1;
        }
        return l >= ns;
    }
};
/*
class Solution {
public:
    bool wordPattern(string pattern, string s) {
        vector<vector<int>> p(26,vector<int>(26));
        vector<bool> isp(26,false);
        int np = pattern.size(), ns = s.size(), l = 0, r = 0;
        while(l < np && r < ns){
            vector<int> cur(26,0);
            if(!isp[pattern[l]-'a']){
                while(r < ns && s[r] != ' '){
                    p[pattern[l]-'a'][s[r]-'a'] += 1;
                    r++;
                }
                for(int j = 0; j < pattern[l]-'a'; j++){
                    if(p[pattern[l]-'a'] == p[j]) return false;
                }
                if(isp[pattern[l]-'a'] && p[pattern[l]-'a'] != cur) return false;
                isp[pattern[l]-'a'] = true;
            }
            else{
                while(r < ns && s[r] != ' '){
                    cur[s[r]-'a'] += 1;
                    r++;
                }
                if(isp[pattern[l]-'a'] && p[pattern[l]-'a'] != cur) return false;
            }
            l++,r++;
        }
        if(r<ns) return false;
        if(l<np) return false;
        return true;
    }
};
*/
