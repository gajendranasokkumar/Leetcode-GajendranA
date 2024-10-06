class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if(sentence1.length() < sentence2.length()) 
            return areSentencesSimilar(sentence2, sentence1);
        
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        
        int i = 0; 
        int j = 0; 
        
        while(i < s2.length && s1[i].equals(s2[i])) {
            i++;
        }
        
        while(j < s2.length && s1[s1.length - 1 - j].equals(s2[s2.length - 1 - j])) {
            j++;
        }
        
        return i + j >= s2.length;
    }
}
