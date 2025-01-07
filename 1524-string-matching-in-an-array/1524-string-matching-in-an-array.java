class Solution {
    public List<String> stringMatching(String[] words) {
        Arrays.sort(words, (a, b) -> b.length() - a.length());
        List<String> list = new ArrayList<>();
        // System.out.println(Arrays.toString(words));
        String pattern;
        int n = words.length;
        boolean[] canpick = new boolean[n];
        for(int i=0;i<n;i++) {
            if(canpick[i])
                continue;
            pattern = words[i];
            for(int j=i+1;j<n;j++) {
                if(pattern.contains(words[j]) && !canpick[j]) {
                    list.add(words[j]);
                    canpick[j] = true;
                }
            }
        }


        return list;
    }
}