// Approach - 03 - O(nlogn) & O(n)
class Solution {
    public int partitionArray(int[] nums, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int val : nums) {
            set.add(val);
        }

        int grp = 0;
        int range = -1;
        for (int val : set) {
            if (val > range) {
                range = val + k;
                grp++;
            }
        }

        return grp;
    }
}