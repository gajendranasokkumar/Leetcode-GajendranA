class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0) return 0;

        PriorityQueue<Long> heap = new PriorityQueue<>();
        HashSet<Long> seen = new HashSet<>();

        heap.add(1L);
        seen.add(1L);

        long[] primes = {2, 3, 5};
        long ugly = 1;

        for (int i = 0; i < n; i++) {
            ugly = heap.poll();

            for (long prime : primes) {
                long nextUgly = ugly * prime;
                if (!seen.contains(nextUgly)) {
                    heap.add(nextUgly);
                    seen.add(nextUgly);
                }
            }
        }

        return (int) ugly;
    }
}