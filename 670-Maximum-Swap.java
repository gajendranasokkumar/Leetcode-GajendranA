class Solution {
    public int maximumSwap(int num) {
        StringBuilder str = new StringBuilder(Integer.toString(num));
        int n = str.length();
        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());

        int idx1 = -1, idx2 = -1;
        int k=n-1;

        for (int i = n - 1; i >= 0; i--) {
            char currentDigit = str.charAt(i);
            if (!pq.isEmpty()) {
                Pair<Character, Integer> largest = pq.peek();

                if (largest.getKey() > currentDigit) {
                    idx1 = i;
                    idx2 = largest.getValue();
                }
            }

            pq.add(new Pair<>(currentDigit, i));
        }

        

        if(idx1 != -1) {
            char temp = str.charAt(idx1);
            str.setCharAt(idx1, str.charAt(idx2));
            str.setCharAt(idx2, temp);
            return Integer.parseInt(str.toString());
        }

        return num;
    }
}
