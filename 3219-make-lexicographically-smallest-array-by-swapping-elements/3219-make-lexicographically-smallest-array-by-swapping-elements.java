import java.util.*;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[] arr = new int[n];
        System.arraycopy(nums, 0, arr, 0, n);
        Arrays.sort(arr);

        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> parent = new HashMap<>();
        Map<Integer, Queue<Integer>> map = new HashMap<>(); // Use Queue instead of List

        // Initialize parent and map
        for (int i : arr) {
            parent.put(i, i);
        }

        for (int i = 0; i < n - 1; i++) {
            if (Math.abs(arr[i] - arr[i + 1]) <= limit) {
                int ul_a = parent.get(arr[i]);
                parent.put(arr[i + 1], ul_a);
                map.putIfAbsent(arr[i], new LinkedList<>()); // Use LinkedList for Queue
                map.get(ul_a).add(arr[i + 1]);
            }
        }

        // System.out.println(map);

        int idx = 0;
        while (idx < n) {
            int ul_a = parent.get(nums[idx]);
            if (!visited.contains(ul_a)) {
                arr[idx] = ul_a;
                visited.add(ul_a);
            } else {
                Queue<Integer> queue = map.get(ul_a);
                int next = queue.poll();
                if (queue.isEmpty()) {
                    map.remove(ul_a);
                }
                arr[idx] = next;
                visited.add(next);
            }
            idx++;
        }

        return arr;
    }
}
