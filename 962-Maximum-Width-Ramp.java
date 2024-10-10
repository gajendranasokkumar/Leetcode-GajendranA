class Solution {
    public int maxWidthRamp(int[] nums) {
        Deque<Integer> deque = new LinkedList<>();
        int n = nums.length;
        int maxi = 0; 

        for (int i = 0; i < n; i++) {
            if (deque.isEmpty() || nums[i] < nums[deque.peekFirst()]) {
                deque.addFirst(i);
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekFirst()]) {
                maxi = Math.max(maxi, i - deque.pollFirst());
            }
        }

        return maxi;
    }
}
