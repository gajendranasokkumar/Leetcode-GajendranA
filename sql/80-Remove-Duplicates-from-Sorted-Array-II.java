class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        Map<Integer, Integer> mp = new LinkedHashMap<Integer, Integer>();
        for(int i=0;i<nums.length;i++)
        {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }
        System.out.println(mp);
        System.out.println(Arrays.toString(nums));
        for(int j : mp.keySet())
        {
            if(mp.get(j) == 1 )
                nums[k++] = j;
            else if(mp.get(j) >= 2 && k < nums.length - 1)
            {
                nums[k++] = j;
                nums[k++] = j;
            }
        }
        System.out.println(Arrays.toString(nums));
        return k;
    }
}