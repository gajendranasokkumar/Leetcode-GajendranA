class Solution {
    public String clearStars(String s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.c == b.c)
                return b.idx - a.idx;
            return a.c - b.c;
        });

        int n = s.length();
        boolean[] marked = new boolean[n];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '*' && !pq.isEmpty()) {
                marked[pq.poll().idx] = true;
            } else {
                pq.add(new Pair(c, i));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c != '*' && !marked[i])
                sb.append(c);
        }

        return sb.toString();
    }
}

class Pair {
    char c;
    int idx;

    Pair(char _c, int _idx) {
        c = _c;
        idx = _idx;
    }
}