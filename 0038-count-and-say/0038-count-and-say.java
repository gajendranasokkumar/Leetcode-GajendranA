class Solution {
    static String[] answers;
    static {
        answers = new String[31];
        answers[1] = "1";
        for(int idx=2; idx<=30; idx++) {
            String prev = answers[idx-1];
            answers[idx] = getRLE(prev);
        }
        // for(int i=1;i<=30;i++) 
        //     System.out.println(answers[i]);
    }
    public static String getRLE(String current) {
        int count = 0;
        int n = current.length();
        int right = 0;
        StringBuilder str = new StringBuilder();
        while(right < n) {
            char curChar = current.charAt(right);
            while(right < n && curChar == current.charAt(right)) {
                right++;
                count++;
            }
            str.append(String.valueOf(count) + curChar);
            count=0;
        }

        return str.toString();
    }
    public String countAndSay(int n) {
        return answers[n];
    }
}