class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        // if there is only one point, the max points will be 1
        if( n == 1) return 1;
        // if there are more points, the max will be at least 2
        int max = 2;
        for(int i=0; i<n-1; i++){
            Map<Double, Integer> tangentMap = new HashMap<>();
            for(int j=0; j<n; j++){
                if(i == j)
                    continue;
                
                int[] p1 = points[i];
                int[] p2 = points[j];
                int x1 = p1[0];
                int y1 = p1[1];
                int x2 = p2[0];
                int y2 = p2[1];
                
                // calculate the tangent..
                double tangent = Math.atan2((y2-y1),(x2-x1));
                int c = tangentMap.getOrDefault(tangent, 0);
                // increase the count..
                tangentMap.put(tangent, c+1);
            }

            // calculate the max points from the tangentMap.
            // To include the point points[i] itself 
            // we added +1 to the values
            max = Math.max(max, Collections.max(tangentMap.values())+1);
        }
        
        return max;
    }
}