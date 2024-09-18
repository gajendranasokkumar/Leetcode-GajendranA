class Solution {
    public String largestNumber(int[] nums) {
        String[] numStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrs[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(numStrs, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                return (y + x).compareTo(x + y);
            }
        });

        if (numStrs[0].equals(\0\)) {
            return \0\;
        }

        StringBuilder largestNum = new StringBuilder();
        for (String numStr : numStrs) {
            largestNum.append(numStr);
        }

        return largestNum.toString();
    }
}