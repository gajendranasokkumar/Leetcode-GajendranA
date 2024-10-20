class Solution {
    public List<String> stringSequence(String target) {
        List<String> result = new ArrayList<>();

        char[] arr = target.toCharArray();
        int idx = 0;
        int i=0;
        String one = "";
        while(i < arr.length) {
            char st = 'a';
            char last = st;
            while(st <= arr[i]) {
                result.add(one + (char)st);
                last = st;
                st++;
            }
            one = one+last;
            i++;
        }
        return result;
    }
}