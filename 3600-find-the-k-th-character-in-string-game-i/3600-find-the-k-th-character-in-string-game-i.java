class Solution {
    public char kthCharacter(int k) {
        StringBuilder sc = new StringBuilder("a");
        while(sc.length() <= k){
            StringBuilder sc1 = new StringBuilder();
            for(int i=0;i<sc.length();i++)
            {
                sc1.append((char)(sc.charAt(i)+1));
            }
            sc.append(sc1.toString());
        }
        return sc.charAt(k-1);
    }
}