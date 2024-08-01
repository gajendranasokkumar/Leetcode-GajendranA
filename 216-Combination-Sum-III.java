class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public void fun(int[] nums, int index,List<Integer> list, int sum, int k, int n)
    {
        if(sum == n && list.size() == k)
        {
            result.add(new ArrayList<>(list));
            return;
        }
    
        if(index == 9)
        {
            return;
        }

        list.add(nums[index]);
        fun(nums, index+1, list, sum+nums[index], k, n);
        list.remove(list.size() - 1);
        fun(nums, index+1, list, sum, k, n);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = new int[10];
        for(int i=0;i<10;i++)
        {
            nums[i] = i+1; 
        }
        List<Integer> list = new ArrayList<>();
        fun(nums, 0, list, 0, k, n);
        return result;
    }
}