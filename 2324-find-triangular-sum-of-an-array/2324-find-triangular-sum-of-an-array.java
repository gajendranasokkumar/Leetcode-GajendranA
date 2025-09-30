class Solution {
    public int triangularSum(int[] nums) {
        Queue<Integer> q = new LinkedList<>();
        for(int num : nums)
            q.add(num);
        while(q.size() != 1) {
            int size = q.size();
            while(size-- > 1) {
                int first = q.poll();
                int second = q.peek();
                q.add((first + second) % 10);
            }
            q.poll();
        }
        return q.peek();
    }
}