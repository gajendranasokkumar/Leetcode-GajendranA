class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
       Stack<Integer>stack = new Stack<>();
     
      for(int i=0;i<=n;i++)
      {
        int currHeight = (i==n) ? 0 : heights[i];

        while(!stack.isEmpty() && currHeight<heights[stack.peek()])
             {
              
                int top = stack.pop();
             int width = stack.isEmpty() ? i: i-stack.peek()-1;
              int area = heights[top]*width;
            maxArea = Math.max(maxArea , area);

                }

           stack.push(i);

         }
       return maxArea;

    }
} 