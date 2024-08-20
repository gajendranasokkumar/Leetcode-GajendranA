class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=nums2.length-1;i>=0;i--)
        {
            if(stack.isEmpty())
            {
                map.put(nums2[i], -1);
            }
            else
            {
                while(!stack.isEmpty() && stack.peek() < nums2[i])
                {
                    stack.pop();
                }
                if(!stack.isEmpty())
                map.put(nums2[i], stack.peek());
                else
                map.put(nums2[i], -1);
            }
            stack.push(nums2[i]);
        }
        System.out.println(map);
        int[] result = new int[nums1.length];
        for(int j=0;j<nums1.length;j++)
        {
            result[j] = map.get(nums1[j]);
        }
        return result;
    }
}