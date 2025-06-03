class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int totalCandies = 0;
        int n = status.length;
        Queue<Integer> q = new LinkedList<>();
        int[] required = new int[n];
        int[] keysObtained = new int[n];
        int init = initialBoxes.length;
        for(int i=0;i<init;i++) {
            if(status[initialBoxes[i]] == 1) {
                q.add(initialBoxes[i]);
            } else {
                required[initialBoxes[i]] = 1;
            }
        }
        
        while(!q.isEmpty()) {
            int idx = q.poll();
            // add Candies to the answer
            totalCandies += candies[idx];
            //process Keys
            for(int nextKey : keys[idx]) {
                if(required[nextKey] == 1) {
                    q.add(nextKey);
                    required[nextKey] = 0;
                } else {
                    keysObtained[nextKey] = 1;
                }
            }
            //process contained box
            for(int nextBox : containedBoxes[idx]) {
                if(status[nextBox] == 1 || keysObtained[nextBox] == 1) {
                    q.add(nextBox);
                } else {
                    required[nextBox] = 1; 
                }
            }
        }

        return totalCandies;
    }
}