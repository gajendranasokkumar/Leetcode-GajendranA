class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;
        while(c > 0) {
            if((c & 1) == 1) {
                if((a&1) == 0 && (b&1) == 0)
                    flips++;
            } else {
                if((a&1) == 1)
                    flips++;
                if((b&1) == 1)
                    flips++;
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }

        while(a != 0 || b != 0) {
            if((a&1) == 1)
                flips++;
            if((b&1) == 1)
                flips++;
            a >>= 1;
            b >>= 1;
        }

        return flips;
    }
}