class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();

        int[] end = new int[26];
        int n = s.length();

        for (int i = 0; i < n; i++) {
            end[s.charAt(i) - 'a'] = i;
        }

        int max = 0; 
        int init = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, end[s.charAt(i) - 'a']);
            if (i == max) { 
                list.add(max - init + 1);
                init = i + 1;
            }
        }

        return list;
    }
}
