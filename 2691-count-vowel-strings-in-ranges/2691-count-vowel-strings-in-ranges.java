class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] vowels = new int[words.length];
        int[] result = new int[queries.length];
        int prev = 0;
        for(int i=0;i<words.length;i++) {
            int count = 0;
            char c = words[i].charAt(0);
            char d = words[i].charAt(words[i].length()-1);
            if((c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') && 
                (d == 'a' || d == 'e' || d == 'i' || d == 'o' || d == 'u'))
                count++;
                
            vowels[i] = prev + count;
            prev = vowels[i];
        }
        int i=0;
        for(int[] arr: queries) {
            if(arr[0] == 0)
                result[i] = vowels[arr[1]];
            else 
                result[i] = vowels[arr[1]] - vowels[arr[0]-1];
            i++;
        }



        return result;
    }
}