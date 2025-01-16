class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int ans = 0;
        int ans1 = 0;
        if (nums2.length % 2 != 0) {
            for (int i = 0; i < nums1.length; i++) {
                ans = ans ^ nums1[i];
            }
        }
        if (nums1.length % 2 != 0) {
            for (int i = 0; i < nums2.length; i++) {
                ans1 = ans1 ^ nums2[i];
            }
        }
        return ans ^ ans1;
    }
}