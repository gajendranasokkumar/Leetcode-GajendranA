class Solution {
    public int minSwaps(String s) {
        int open = 0, close = 0, mis = 0;
        for(char i: s.toCharArray()) {
            if(i == '[')
                open++;
            else if(i == ']')
                if(open > 0)
                    open--;
                else
                    mis++;
        }

        return (mis/2) + (mis%2);
    } 
}