class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> list;
    int index;
    Random rand;
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        index = 0;
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        
        map.put(val, index);
        list.add(val);
        index++;
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int idx = map.get(val);
        
        int lastElement = list.get(index - 1);
        list.set(idx, lastElement);
        map.put(lastElement, idx);

        list.remove(index - 1);
        map.remove(val);

        index--;
        
        return true;
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(index));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */