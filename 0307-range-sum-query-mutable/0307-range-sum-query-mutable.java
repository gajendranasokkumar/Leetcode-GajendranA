class NumArray {
    int[] segmentTree, arr;
    int n;

    public NumArray(int[] nums) {
        n = nums.length;
        segmentTree = new int[4 * n];
        arr = nums.clone();  // Clone to prevent modification issues
        buildTree(0, n - 1, 0);
    }
    
    public void update(int index, int val) {
        int diff = val - arr[index];  // Find the difference
        arr[index] = val;             // Update the array
        updateTree(0, n - 1, index, diff, 0);
    }
    
    public int sumRange(int left, int right) {
        return query(0, n - 1, left, right, 0);
    }

    private int query(int start, int end, int left, int right, int idx) {
        if (start > right || end < left) 
            return 0;
        if (start >= left && end <= right)
            return segmentTree[idx];
        int mid = start + (end - start) / 2;
        return query(start, mid, left, right, 2 * idx + 1) + 
               query(mid + 1, end, left, right, 2 * idx + 2);
    }

    private int buildTree(int left, int right, int idx) {
        if (left == right) 
            return segmentTree[idx] = arr[left];

        int mid = left + (right - left) / 2;
        int leftChild = buildTree(left, mid, 2 * idx + 1);
        int rightChild = buildTree(mid + 1, right, 2 * idx + 2);
        segmentTree[idx] = leftChild + rightChild;
        return segmentTree[idx];
    }

    private void updateTree(int start, int end, int index, int diff, int idx) {
        if (index < start || index > end) return;

        segmentTree[idx] += diff;  // Update the value
        if (start != end) {
            int mid = start + (end - start) / 2;
            updateTree(start, mid, index, diff, 2 * idx + 1);
            updateTree(mid + 1, end, index, diff, 2 * idx + 2);
        }
    }
}
