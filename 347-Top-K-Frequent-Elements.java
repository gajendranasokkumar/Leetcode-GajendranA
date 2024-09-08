class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(k, (a, b) -> a.frequency - b.frequency);
        
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int element = entry.getKey();
            int frequency = entry.getValue();
            
            Pair pair = new Pair(frequency, element);
            
            if (minHeap.size() < k) {
                minHeap.offer(pair);
            } else if (frequency > minHeap.peek().frequency) {
                minHeap.poll();
                minHeap.offer(pair);
            }
        }
        
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll().element;
        }
        
        return result;
    }
    
    private class Pair {
        int frequency;
        int element;
        
        public Pair(int frequency, int element) {
            this.frequency = frequency;
            this.element = element;
        }
    }
}
