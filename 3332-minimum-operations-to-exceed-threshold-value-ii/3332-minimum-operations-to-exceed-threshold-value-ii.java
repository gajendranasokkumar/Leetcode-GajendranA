class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> q = new PriorityQueue<>();
        for(int i : nums)
            q.add((long)i);
        int operation = 0;
        while(!q.isEmpty() && q.peek() < k) {
            long one = q.poll();
            if(q.isEmpty())
                break;
            long two = q.poll();
            long newnum = Math.min(one, two) * 2 + Math.max(one, two);
            q.offer(newnum);
            operation++;
        }
        return operation;
    }
}