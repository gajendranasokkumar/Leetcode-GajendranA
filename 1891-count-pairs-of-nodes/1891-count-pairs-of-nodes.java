import java.util.*;

class Solution {
    public int[] countPairs(int n, int[][] edges, int[] queries) {
        // Step 1: Build degree array and edge map
        int[] degree = new int[n + 1];
        Map<Integer, Integer> sharedEdges = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            degree[u]++;
            degree[v]++;
            int key = Math.min(u, v) * (n + 1) + Math.max(u, v);
            sharedEdges.put(key, sharedEdges.getOrDefault(key, 0) + 1);
        }

        // Step 2: Count pairs of nodes
        int[] sortedDegrees = degree.clone();
        Arrays.sort(sortedDegrees);

        // Prepare results
        int[] result = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int threshold = queries[q];
            int count = 0;

            // Step 3: Two-pointer approach to count pairs
            int left = 1, right = n;
            while (left < right) {
                if (sortedDegrees[left] + sortedDegrees[right] > threshold) {
                    count += (right - left); // All pairs (left, left+1, ..., right-1)
                    right--;
                } else {
                    left++;
                }
            }

            // Step 4: Adjust for shared edges
            for (Map.Entry<Integer, Integer> entry : sharedEdges.entrySet()) {
                int u = entry.getKey() / (n + 1);
                int v = entry.getKey() % (n + 1);
                int shared = entry.getValue();
                if (degree[u] + degree[v] > threshold && degree[u] + degree[v] - shared <= threshold) {
                    count--;
                }
            }

            result[q] = count;
        }

        return result;
    }
}
