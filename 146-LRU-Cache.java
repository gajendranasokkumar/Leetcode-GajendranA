class LRUCache {
    Deque<Integer> deque;
    Map<Integer, Integer> map;
    int capacity;
    public LRUCache(int capacity) {
        this.deque = new ArrayDeque<>();
        this.map = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1; 
        }
        deque.remove(key);
        deque.addFirst(key);
        return map.get(key);
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            deque.remove(key);
            deque.addFirst(key);  
        } else {
            if (deque.size() == capacity) {
                int lruKey = deque.removeLast();
                map.remove(lruKey);
            }
            map.put(key, value);
            deque.addFirst(key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */