class Solution {
public long maximumImportance(int n, int[][] roads) {
        long[] indegree = new long[n];
        for(int[] road:roads){
            indegree[road[0]]++;
            indegree[road[1]]++;
        }
        Arrays.sort(indegree);
        long res = 0;
        int value = 1;
        for(long d:indegree){
            res+= d*value;
            value++;
        }
        return  res;
    }
}