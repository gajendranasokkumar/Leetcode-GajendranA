class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int max = 0, sum = 0, min;
        while(left < right)
        {
            min = Math.min(height[left], height[right]);
            sum = min * (right - left);
            max = (max < sum) ? sum : max;
            if(min == height[left])
            {
                left++;
            }
            else if(min == height[right])
            {
                right--;
            }
        }
        return max;
    }
}