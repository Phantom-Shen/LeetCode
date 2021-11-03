class Solution {
public:
    string minWindow(string s, string t) {
        int ns = s.size(), nt = t.size(), l = 0, r = 0, minl = -1, minr = ns, minLen = INT_MAX;
        if(nt>ns) return "";
        vector<int> dps(52,0), dpt(52,0);
        for(int i = 0; i < nt; i++){
            dpt[key(t[i])]+=1;
        }
        
        while(r < ns){
            if(dpt[key(s[r])] > 0){
                dps[key(s[r])] += 1;
            }
            r++;
            while(isContain(dps,dpt)){
                if(r-l<minr-minl){
                    minl = l;
                    minr = r;
                    minLen = r-l;
                }
                if(dps[key(s[l])]>0) dps[key(s[l])] -= 1; // pop front off the window
                l++;
            }
        }
        if(minl == -1) return "";
        return s.substr(minl, minr-minl);
    }
    
private:
    bool isContain(const vector<int>& dps, const vector<int>& dpt){
        for(int i = 0; i < dps.size(); i++){
            if(dps[i]<dpt[i]) return false;
        }
        return true;
    }
    
    int key(char c){
        if(c>='a' && c <= 'z') return c-'a';
        else return c-'A'+26;
    }
};

/*
class Solution {
public:
    string minWindow(string s, string t) {
        int ns = s.size(), nt = t.size();
        if(ns<nt) return "";
        vector<int> dt(52,0), ds(52,0); // hash table
        int dt_num = 0, ds_num = 0;  // number of element in d
        int key=0, l = 0, r = 0, minl = 0,minr = ns+1; // slow and fast pointer
        
        for(int i = 0; i < nt; i++) { // prepare hash table for string t
            key = getKey(t[i]);
            if(key!=-1) {
                dt[key] += 1;
                dt_num++;
            }
        }
        while(r < ns){
            if(ds_num < dt_num){
                key = getKey(s[r]);
                if(dt[key]>0){
                    if(ds[key] < dt[key]) ds_num++;
                    ds[key]+=1;
                }
                r++;
            }
            if(ds_num == dt_num){ // found a valid sub array
                while(l<r){
                    if(r-l < minr-minl){
                        //cout << "new min " << l << ", "<< r << endl;
                        minl = l;
                        minr = r;
                    }
                    key = getKey(s[l]);
                    if(dt[key]>0){
                        if(ds[key]-1 < dt[key]){
                            l++;
                            ds[key] -= 1;
                            ds_num -= 1;
                            break;
                        }
                        ds[key] -= 1;
                    }
                    l++;
                }
            }
            
        }
        if(minr == ns+1) return ""; // nothing found
        return s.substr(minl,minr-minl);
    }
    
private:
    int getKey(char c){ // 0-25 -> 'A' - 'Z'; 26 - 51 -> 'a' - 'z'
        if(c >= 'A' && c <= 'Z') return c-'A';
        else if(c >= 'a' && c <= 'z') return 26+c-'a';
        return -1;
    }
};
*/
/*
// Too slow!!!  265/266 test cases pass
class Solution {
public:
    string minWindow(string s, string t) {
        cout << "string: " << s << endl;
        int ns = s.size(), nt = t.size();
        if(ns<nt) return "";
        vector<int> dt(52,0), ds(52,0); // hash table
        int dt_num = 0, ds_num = 0;  // number of element in d
        int key=0, l = 0, r = 0, minl = -1,minr = ns,nextl = -1; // slow and fast pointer
        // traverse through the list with r.
        // Increment i to the next char in string t,when a valid window substring is found.
        // ......
        for(int i = 0; i < nt; i++) { // prepare hash table for string t
            key = getKey(t[i]);
            if(key!=-1) {
                dt[key] += 1;
                dt_num++;
            }
        }
        cout << "l and r:" << l << ", " << r << " dt_num and ds_num: " << dt_num << ", " << ds_num << endl;
        while(r < ns){
            key = getKey(s[r]);
            if(dt[key] != 0) { // current char in s is in t
                if(nextl == -1) nextl = r;
                if(ds[key]<dt[key]) ds_num++; // if ds[key] == dt[key] -> we have found every char of this kind. Keep find others.
                ds[key]+=1;  
            }   
            r++;
            // make sure r-l <= minr - minl
            if(r-l>minr-minl){
                key = getKey(s[l]);
                if(dt[key] > 0){ // s[l] is in t
                    ds[key] -= 1;
                    dt_num -= 1;
                }
                l++;
            }
            
            cout << "l and r:" << l << ", " << r << " dt_num and ds_num: " << dt_num << ", " << ds_num << endl;
            if(ds_num == dt_num){ // ?????????? a valid sub array is found 
                while(l < r){ // check if duplicate in side current sub array, if so, shrink the length
                    key = getKey(s[l]);
                    if(dt[key] > 0){ // s[l] is in t
                        if(ds[key]-1 < dt[key]){ // we cannot remove current char
                            break;
                        }
                        ds[key]-=1;
                    }
                    l++;
                }
                if(r-l<minr-minl){ // if current length less than min
                    cout << "new min " << l << ", "<< r << endl;
                    minl = l;
                    minr = r;
                    if(minr-minl == nt) return s.substr(minl,minr-minl); // this is the bet solution we can get
                }
                
                if(nextl>=l) l = nextl;
                r = l+1;
                nextl = -1;
                // clear ds and ds_num
                clearDict(ds);
                ds[getKey(s[r-1])] = 1;
                ds_num = 1;
            }
            
        }
        if(minl == -1) return ""; // minl is not changed -> nothing found
        return s.substr(minl,minr-minl);
    }
    
private:
    void clearDict(vector<int>& d){
        int n = d.size();
        for(int i = 0; i < n;i++){
            d[i] = 0;
        }
    }
    
    int getKey(char c){ // 0-25 -> 'A' - 'Z'; 26 - 51 -> 'a' - 'z'
        if(c >= 'A' && c <= 'Z') return c-'A';
        else if(c >= 'a' && c <= 'z') return 26+c-'a';
        return -1;
    }
};
*/
