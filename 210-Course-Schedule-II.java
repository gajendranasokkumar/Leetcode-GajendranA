class Solution {
    public static int[] reverseArray(int[] array) {
        int start = 0;
        int end = array.length - 1;
        
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            
            start++;
            end--;
        }
        return array; 
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses]; 
        Queue<Integer> queue = new LinkedList<>();

        Map<Integer, ArrayList<Integer>> adj = new HashMap<>();

        for(int[] i: prerequisites) {
            adj.putIfAbsent(i[0], new ArrayList<Integer>());
            adj.get(i[0]).add(i[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if(adj.containsKey(i))
                for (int neighbor : adj.get(i)) {
                    inDegree[neighbor]++;
                }
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int countVisited = 0; 
        int[] result = new int[numCourses];

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result[countVisited++] = node; 
            if(adj.containsKey(node))
            for (int neighbor : adj.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return countVisited == numCourses ? reverseArray(result) : new int[0];
    }
}