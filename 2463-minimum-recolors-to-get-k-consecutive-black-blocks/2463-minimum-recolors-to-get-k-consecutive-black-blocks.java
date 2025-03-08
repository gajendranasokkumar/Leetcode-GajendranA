class Solution {
    public int minimumRecolors(String blocks, int k) {
        char[] arr = blocks.toCharArray();
        int left = 0, right = 0;
        int n = arr.length;
        int min = n, white = 0;
        while(right < n) {
            if(arr[right] == 'W')
                white++;
            if(right - left + 1 == k) {
                min = Math.min(min, white);
                if(arr[left] == 'W')
                    white--;
                left++;
            }
            right++;
        }
        return min;
    }
}