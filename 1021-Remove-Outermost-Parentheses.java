class Solution {
    public String removeOuterParentheses(String s) {
        char[] chr=s.toCharArray();
        int c=1,l=chr.length,i=1;
        StringBuilder res=new StringBuilder();
        while(i<l){
            if(chr[i]=='(')c++;
            else c--;
            if(c==0){
                i+=2;
                c=1;
            }else{
                res.append(chr[i]);
                i++;
            }
        }
        return res.toString();
    }
}