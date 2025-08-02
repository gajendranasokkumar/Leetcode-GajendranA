class Solution {
    public long minCost(int[] basket1, int[] basket2) {

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> onefreq = new HashMap<>();
        Map<Integer, Integer> twofreq = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Set<Integer> seen = new HashSet<>();

        int n = basket1.length;
        int globalMin = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            // Avoid O(n^2) contains() check
            if (seen.add(basket1[i])) pq.add(basket1[i]);
            if (seen.add(basket2[i])) pq.add(basket2[i]);

            onefreq.put(basket1[i], onefreq.getOrDefault(basket1[i], 0) + 1);
            twofreq.put(basket2[i], twofreq.getOrDefault(basket2[i], 0) + 1);

            map.put(basket1[i], map.getOrDefault(basket1[i], 0) + 1);
            map.put(basket2[i], map.getOrDefault(basket2[i], 0) + 1);

            globalMin = Math.min(globalMin, Math.min(basket1[i], basket2[i]));
        }

        for (int count : map.values()) {
            if (count % 2 != 0) return -1;
        }

        List<Integer> toSwap = new ArrayList<>();
        for (int key : map.keySet()) {
            int f1 = onefreq.getOrDefault(key, 0);
            int f2 = twofreq.getOrDefault(key, 0);
            int diff = Math.abs(f1 - f2);
            for (int i = 0; i < diff / 2; i++) {
                toSwap.add(key);
            }
        }

        Collections.sort(toSwap);
        long totalCost = 0;
        for (int i = 0; i < toSwap.size() / 2; i++) {
            totalCost += Math.min(toSwap.get(i), globalMin * 2);
        }

        return totalCost;
    }
}
