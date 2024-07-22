bool isAnagram(char* s, char* t) {
    if(strlen(s) != strlen(t))
        return false;
    
    int a[26] = {0};
    for(int i=0; s[i] && t[i]; ++i)
    {
        ++a[s[i] - 'a'];
        --a[t[i] - 'a'];
    } 
    for(int i=0;i<26;i++)
    {
        if(a[i]!=0)
            return false;
    }
    return true;
}