class SnapshotArray {
    private Map<Integer, TreeMap<Integer, Integer>> map;
    private int snapId;

    public SnapshotArray(int length) {
        map = new HashMap<>();
        snapId = 0;
        for (int i = 0; i < length; i++) {
            map.put(i, new TreeMap<>());
            map.get(i).put(0, 0); 
        }
    }
    
    public void set(int index, int val) {
        map.get(index).put(snapId, val);
    }
    
    public int snap() {
        return snapId++;
    }
    
    public int get(int index, int snap_id) {
        return map.get(index).floorEntry(snap_id).getValue();
    }
}


/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */