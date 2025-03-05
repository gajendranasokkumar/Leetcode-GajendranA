class Solution {
    public long coloredCells(long n) {
        return 1L + (4L * (n * (n - 1L)) / 2L);
    }
}
