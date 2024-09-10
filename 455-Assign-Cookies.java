class Solution {
    public int findContentChildren(int[] g, int[] s) {
       Arrays.sort(g);
       Arrays.sort(s);
       int cnt=0;
       for(int i=0,j=0;i<g.length;){
           if(j>=s.length) break;
           if(g[i]>s[j]){
               j++;
           }else{
               cnt++;
               i++;j++;
           }
       }
       return cnt;
    }
}