class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public void fun(int[] nums, int n, int index, List<Integer> list) {
        if (index == n) {
            return;
        }
        list.add(nums[index]);
        if (!result.contains(new ArrayList<>(list))) {
            result.add(new ArrayList<>(list));
            System.out.println(list);
        }

        fun(nums, n, index + 1, list);
        list.remove(list.size() - 1);
        fun(nums, n, index + 1, list);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> li = new ArrayList<Integer>();
        result.add(new ArrayList<>());
        fun(nums, nums.length, 0, li);
        return result;
    }
}