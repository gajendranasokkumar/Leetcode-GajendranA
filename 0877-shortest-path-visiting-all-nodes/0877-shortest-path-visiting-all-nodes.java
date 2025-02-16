class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int maxMask = 1 << n;

        boolean[][] visited = new boolean[n][maxMask];

        Queue<int[]> queue = new LinkedList<>();

        for (int i=0; i<n; i++){
            queue.offer(new int[]{i, 1 << i});
            visited[i][1 << i] = true;
        }

        int steps = 0;

        while (!queue.isEmpty()){
            int size = queue.size();

            while(size-- > 0) {
                int[] top = queue.poll();
                int curr = top[0], mask = top[1];
                if (mask == maxMask-1) return steps;

                for (int nei: graph[curr]){
                    int newMask = mask | 1 << nei;
                    if (!visited[nei][newMask]){
                        visited[nei][newMask] = true;
                        queue.offer(new int[]{nei, newMask});
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}