class Solution {
    public int edgeScore(int[] edges) {
    long[] scores = new long[edges.length];
        
        for (int i = 0; i < edges.length; i++) {
            scores[edges[i]] += i;
        }
      
        int maxNode = 0;
        long maxScore = scores[0];
        
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > maxScore) {
                maxScore = scores[i];
                maxNode = i;
            }
        }
        
        return maxNode;    
    }
}