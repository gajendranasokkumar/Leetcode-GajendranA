class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> q = new PriorityQueue<>();
        for(int i : nums)
            q.add((long)i);
        int operation = 0;
        while(q.peek() < k) {
            long one = q.poll();
            long two = q.poll();
            long newnum = one * 2 + two;
            q.offer(newnum);
            operation++;
        }
        return operation;
    }
}