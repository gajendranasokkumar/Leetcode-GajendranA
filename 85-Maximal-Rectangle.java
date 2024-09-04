class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= n; i++) {
            int currHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {

                int top = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int area = heights[top] * width;
                maxArea = Math.max(maxArea, area);

            }

            stack.push(i);

        }
        return maxArea;

    }
    public int maximalRectangle(char[][] matrix) {
        int[][] box = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix[0].length;i++)
        {
            int s = 0;
            for(int j=0;j<matrix.length;j++)
            {
                if(matrix[j][i] == '1')
                    s++;
                else
                    s=0;
                box[j][i] = s;
            }
        } 
        int max = 0;
        for(int[] a: box)
            max = Math.max(max, largestRectangleArea(a));
        return max;
    }
}