public class Solution {
    public String longestDiverseString(int a, int b, int c) {
        Pair<Character, Integer> A = new Pair<>('a', a);
        Pair<Character, Integer> B = new Pair<>('b', b);
        Pair<Character, Integer> C = new Pair<>('c', c);
        
        StringBuilder result = new StringBuilder();

        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>((x, y) -> y.getValue() - x.getValue());

        if (A.getValue() > 0) pq.add(A);
        if (B.getValue() > 0) pq.add(B);
        if (C.getValue() > 0) pq.add(C);

        while (!pq.isEmpty()) {
            Pair<Character, Integer> first = pq.poll();
            char ch1 = first.getKey();
            int count1 = first.getValue();

            if (result.length() >= 2 && result.charAt(result.length() - 1) == ch1 && result.charAt(result.length() - 2) == ch1) {
                if (pq.isEmpty()) {
                    break;
                }

                Pair<Character, Integer> second = pq.poll();
                char ch2 = second.getKey();
                int count2 = second.getValue();

                result.append(ch2);

                if (count2 - 1 > 0) {
                    pq.add(new Pair<>(ch2, count2 - 1));
                }

                pq.add(first);
            } else {
                result.append(ch1);

                if (count1 - 1 > 0) {
                    pq.add(new Pair<>(ch1, count1 - 1));
                }
            }
        }

        return result.toString();
    }
}
