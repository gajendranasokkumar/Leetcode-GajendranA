class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();

        int total = 1 << n; // 2^n numbers

        for (int i = 0; i < total; i++) {
            result.add(i ^ (i >> 1)); // Gray code formula
        }

        return result;
    }
}