import java.util.*;

class Solution {
    public int catchThieves(char[] arr, int k) {
        int n = arr.length;
        Queue<Integer> police = new LinkedList<>();
        Queue<Integer> thieves = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P') {
                police.add(i);
            } else if (arr[i] == 'T') {
                thieves.add(i);
            }
        }

        while (!police.isEmpty() && !thieves.isEmpty()) {
            int pIndex = police.peek();
            int tIndex = thieves.peek();

            if (Math.abs(pIndex - tIndex) <= k) {
                count++;
                police.poll();
                thieves.poll();
            } else if (pIndex < tIndex) {
                police.poll(); // This policeman can't catch that thief
            } else {
                thieves.poll(); // This thief is out of reach
            }
        }

        return count;
    }
}
