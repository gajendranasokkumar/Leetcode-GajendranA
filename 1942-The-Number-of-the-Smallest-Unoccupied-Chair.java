class Friend {
    int start;
    int end;
    int chair;

    public Friend(int s, int e, int c) {
        this.start = s;
        this.end = e;
        this.chair = c;
    }

    public String toString() {
        return "[ Start: " + start + " End: " + end + " Chair: " + chair + " ]";
    }
}
// Map<Integer, Friend> map = new HashMap<>();
// PriorityQueue<Friend> pq = new PriorityQueue<Friend>((a, b) -> a.end -
// b.end);

class Solution {
    public int smallestChair(int[][] times, int targetFriend) {

        int find = times[targetFriend][0];

        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        List<Friend> list = new ArrayList<>();

        Arrays.sort(times, (a, b) -> a[0] - b[0]);

        for (int i = 0; i < times.length; i++) {
            availableChairs.add(i); 
        }

        for (int i = 0; i < times.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                Friend one = list.get(j);
                if (one.end <= times[i][0]) {
                    availableChairs.add(one.chair); 
                    list.remove(j);
                    j--;    
                }
            }

            if (times[i][0] == find) {
                return availableChairs.peek();
            }

            int assignedChair = availableChairs.poll();
            list.add(new Friend(times[i][0], times[i][1], assignedChair));
        }

        return -1;
    }
}