class Solution {
    public String frequencySort(String s) {
        
        char[] arr = s.toCharArray();
        int[] freq = new int[123];

        for(char ch : arr)
        {
            freq[ch]++;
        }

        for(int i = 0; i<s.length();)
        {
            char max = '.';
            for(int j = 0; j<123; j++)
            {
                if(freq[j] > freq[max])
                {
                    max = (char)j;
                }
            }
            while(freq[max] > 0)
            {
                arr[i++] = max;
                freq[max]--;
            }
        }

        return new String(arr);
    }
}
