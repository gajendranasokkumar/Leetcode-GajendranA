import java.util.Arrays;

class Solution {
    public boolean isConsecutiveAndSorted(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public int[] resultsArray(int[] nums, int k) {
        int len = nums.length;
        int[] result = new int[len - k + 1];
        for (int i = 0; i <= len - k; i++) {
            int[] subArray = Arrays.copyOfRange(nums, i, i + k);
            if (isConsecutiveAndSorted(subArray)) {
                result[i] = subArray[subArray.length - 1];
            } else {
                result[i] = -1;
            }
        }

        return result;
    }
    
}
