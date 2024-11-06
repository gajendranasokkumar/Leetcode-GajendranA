class Solution {
    private static class Pair {
        int sum;
        int i;
        int j;

        public Pair(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> pairs = new ArrayList<>();
        int listLength = nums1.length;

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.sum - b.sum);

        for (int i = 0; i < Math.min(k, listLength); i++) {
            minHeap.add(new Pair(nums1[i] + nums2[0], i, 0));
        }

        int counter = 0;
        while (!minHeap.isEmpty() && counter < k) {
            Pair pair = minHeap.poll();
            int i = pair.i;
            int j = pair.j;

            pairs.add(Arrays.asList(nums1[i], nums2[j]));

            int nextElement = j + 1;

            if (nums2.length > nextElement) {
                minHeap.add(new Pair(nums1[i] + nums2[nextElement], i, nextElement));
            }
            counter++;
        }

        return pairs;
    }
}