class Solution {
    public boolean hasMatch(String s, String p) {
        int star=-1;
        for(int i=0;i<p.length();i++){
            if(p.charAt(i)=='*'){
                star=i;
                break;
            }
        }
        String a=p.substring(0,star);
        String b=p.substring(star+1);
        if(!a.isBlank() && !b.isBlank()){
            int tt=s.indexOf(a);
            if(tt==-1) return false;
            tt=s.indexOf(b,tt+a.length());
            if(tt==-1) return false;
        }else if(!a.isBlank() && b.isBlank()){
            int tt=s.indexOf(a);
            if(tt==-1) return false;
        }else if(a.isBlank() && !b.isBlank()){
            int tt=s.indexOf(b);
            if(tt==-1) return false;
        }else{
            return true;
        }
        return true;
    }
}