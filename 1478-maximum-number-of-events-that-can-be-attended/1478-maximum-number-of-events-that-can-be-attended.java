class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0])); 

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int day = 0, i = 0, n = events.length, count = 0;

        while (i < n || !pq.isEmpty()) {
            if (pq.isEmpty()) {
                day = events[i][0]; // jump to next event's start day
            }

            while (i < n && events[i][0] <= day) {
                pq.offer(events[i][1]); // push event's end day
                i++;
            }

            pq.poll(); // attend the event with the earliest end day
            count++;
            day++;

            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll(); // remove expired events
            }
        }

        return count;
    }
}
