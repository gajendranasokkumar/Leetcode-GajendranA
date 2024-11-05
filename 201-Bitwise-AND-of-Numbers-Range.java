class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int ans = 0;
        for(int i = 30; i >= 0; i--) {
            int bit = 1 << i;
            // Check if both numbers have the same bit set
            if((left & bit) == (right & bit)) {
                // If both have the same bit, add it to answer
                ans |= (left & bit);
            } else {
                // If bits are different, break as all remaining bits will be 0
                break;
            }
        }
        return ans;
    }
}