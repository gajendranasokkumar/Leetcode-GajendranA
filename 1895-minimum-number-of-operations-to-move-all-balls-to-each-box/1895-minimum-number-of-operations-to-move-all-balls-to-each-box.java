class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int balls = boxes.charAt(0) == '1' ? 1 : 0;
        for(int i=1;i<n;i++) {
            prefix[i] = balls + prefix[i-1];
            balls += boxes.charAt(i) == '1' ? 1 : 0;
        }
        balls = boxes.charAt(n-1) == '1' ? 1 : 0;
        for(int i=n-2;i>=0;i--) {
            suffix[i] = balls + suffix[i+1];
            balls += boxes.charAt(i) == '1' ? 1 : 0;
        }

        // System.out.println(Arrays.toString(prefix));
        // System.out.println(Arrays.toString(suffix));

        for(int i=0;i<n;i++) 
            prefix[i] = prefix[i] + suffix[i];
            
        return prefix;
    }
}