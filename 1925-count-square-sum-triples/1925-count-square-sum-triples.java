class Solution {
    public int countTriples(int n) {
        int result = 0;
        int end = n * n;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int c = (int) Math.sqrt(i * i + j * j);
                if (c * c == i * i + j * j && c <= n)
                    result++;
            }
        }
        return result;
    }
}