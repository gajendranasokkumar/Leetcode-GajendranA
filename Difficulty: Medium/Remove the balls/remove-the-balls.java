class Solution {
    public int findLength(int[] color, int[] radius) {
        int idx = 1;
        int n = color.length;
        if(n == 0)
            return 0;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{color[0], radius[0]});
        while(idx < n) {
            if(stack.isEmpty()) {
                stack.push(new int[]{color[idx], radius[idx]});
                idx++;
                continue;
            }
            int[] arr = stack.peek();
            if(arr[0] == color[idx] && arr[1] == radius[idx]) {
                stack.pop();
            } else {
                stack.push(new int[]{color[idx], radius[idx]});
            }
            idx++;
        }
        return stack.size();
    }
}