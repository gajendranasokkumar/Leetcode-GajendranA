class Solution {
   public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

       
        for (int i = 2 * n - 1; i >= 0; i--) {
            int idx = i % n;
      
            while (!stack.isEmpty() && stack.peek() <= nums[idx]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[idx] = stack.peek();
            }
            stack.push(nums[idx]);
        }

        return ans;
    }
}