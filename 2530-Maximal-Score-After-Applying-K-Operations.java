class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for(int i: nums)
            pq.add(i);

        long sum = 0L;
        while(k > 0){
            int num = pq.poll();
            sum += num;
            pq.add((num+2) / 3);
            k--;
        }


        return sum;
    }
}