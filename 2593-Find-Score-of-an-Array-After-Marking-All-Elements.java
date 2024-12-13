class Solution {
    public long findScore(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        long s = 0;
        int p = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != Integer.MAX_VALUE) {
                if (i < nums.length - 1 && nums[i] <= p && nums[i] <= nums[i + 1]) {
                    s = s + nums[i];
                    nums[i + 1] = Integer.MAX_VALUE;
                    if (i - 1 >= 0) {
                        nums[i - 1] = Integer.MAX_VALUE;
                    }
                    nums[i] = Integer.MAX_VALUE;
                }
                else if (i == nums.length - 1) {

                    if (nums[i] <= p) {
                        s = s + nums[i];

                        nums[i - 1] = Integer.MAX_VALUE;
                        nums[i] = Integer.MAX_VALUE;
                    }
                }
            }
            p = nums[i];
        }

        p = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != Integer.MAX_VALUE) {
                if (i > 0 && nums[i] <= p && nums[i] <= nums[i - 1]) {
                    s = s + nums[i];
                    nums[i - 1] = Integer.MAX_VALUE;
                    if (i + 1 < nums.length) {
                        nums[i + 1] = Integer.MAX_VALUE;
                    }
                    nums[i] = Integer.MAX_VALUE;
                } else if (i == 0) {
                    if (nums[i] <= p) {
                        s = s + nums[i];
                        nums[i] = Integer.MAX_VALUE;
                    }
                }
            }
            p = nums[i];
        }

        return s;
    }
}