class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        Set<String> set = new HashSet<>();
        for (String s : nums)
            set.add(s);
        return gen(new StringBuilder(), 0, n, set);
    }

    public String gen(StringBuilder str, int idx, int n, Set<String> set) {
        if (idx == n) {
            String candidate = str.toString();
            return !set.contains(candidate) ? candidate : null;
        }
        
        str.append("0");
        String first = gen(str, idx + 1, n, set);
        if (first != null) return first;
        str.deleteCharAt(str.length() - 1);

        str.append("1");
        String second = gen(str, idx + 1, n, set);
        str.deleteCharAt(str.length() - 1);
        return second;
    }
}
