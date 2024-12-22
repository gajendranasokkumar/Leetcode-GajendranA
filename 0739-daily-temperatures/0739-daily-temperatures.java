class Solution {
    public int[] dailyTemperatures(int[] nums) {
        int n = nums.length;
        int[] maxindex = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(n-1);
        for(int i=n-2;i>=0;i--) {
            while(!stack.isEmpty() && nums[i] >= nums[stack.peek()]) 
                stack.pop();
            maxindex[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(i);
        }

        // System.out.println(Arrays.toString(maxindex));

        for(int i=0;i<n;i++) {
            if(maxindex[i] != 0)
                nums[i] = maxindex[i] - i;
            else
                nums[i] = 0;
        }

        return nums;
    }
}