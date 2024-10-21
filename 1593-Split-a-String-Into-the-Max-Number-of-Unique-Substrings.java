class Solution {
    public int maxUniqueSplit(String s) {
        if (s.length() == 0)
            return 0;
        Set<String> set = new HashSet<>();
        return check(s.toCharArray(), s.length(), 0, set);
    }

    public int check(char[] arr, int size, int index, Set<String> set) {
        if (index == size) {
            return 0;  
        }

        int maxSplit = 0;
        String one = "";

        for (int i = index; i < size; i++) {
            one += arr[i]; 

            if (!set.contains(one)) {
                set.add(one);  
                
                int splitCount = 1 + check(arr, size, i + 1, set);
                maxSplit = Math.max(maxSplit, splitCount);
                
                set.remove(one);
            }
        }

        return maxSplit;
    }
}
