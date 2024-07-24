class Solution {
    public static boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
                || c == 'U');
    }

    public boolean doesAliceWin(String s) {
        char[] str = s.toCharArray();
        int count = 0;
        for (char i : str) {
            if (isVowel(i))
                count++;
        }
        System.out.println(count);

        boolean turn = true;
        // while(count >= 0)
        // {
        // if(turn && count >= 1)
        // {
        // turn = false;
        // count -= 1;
        // }
        // else if(!turn && count >= 2)
        // {
        // turn = true;
        // count -= 2;
        // }
        // else
        // count--;
        // }

        while (count > 0) {
            if (true) {
                if (count % 2 == 0) {
                    count = 1;
                } else {
                    return true;
                }
            }
        }

        return false;
    }
}