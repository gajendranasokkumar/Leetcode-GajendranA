class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] arr = new int[26];  
        int[] window = new int[26];  

        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 > len2) return false; 

        for (char c : s1.toCharArray())
            arr[c - 'a']++;

        for (int right = 0; right < len2; right++) {
            window[s2.charAt(right) - 'a']++;

            if (right >= len1)
                window[s2.charAt(right - len1) - 'a']--;

            if (matches(arr, window))
                return true;
        }

        return false;
    }

    private boolean matches(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }
        return true;
    }
}
