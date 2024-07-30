class Solution {
    public List<List<Integer>> recursion(int index, int[] nums, List<Integer> temp, List<List<Integer>> original) {
        original.add(new ArrayList<>(temp));

        for (int i = index; i < nums.length; i++) {
            if(!temp.contains(nums[i]))
            temp.add(nums[i]);
            recursion(i + 1, nums, temp, original);
            temp.remove(temp.size() - 1);
        }

        return original;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> original = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        recursion(0, nums, temp, original);
        return original;
    }
}