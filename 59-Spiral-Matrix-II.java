class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int m = n;

        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};


        int curr_i = 0;
        int curr_j = 0;
        int curr_idx = 0;
        List<Integer> ans = new ArrayList<>();
        int maxi = n * m; // maximum number of ele will be rows X cols

        int i=1;
        while(ans.size() < maxi){
            // add the curr ele in the arrayList
            ans.add(matrix[curr_i][curr_j]);

            // mark the ele as 1000 as range is (-100, 100)
            matrix[curr_i][curr_j] = i++;

            // go in the same direction
            int new_i = curr_i + dir[curr_idx][0];
            int new_j = curr_j + dir[curr_idx][1];

            // check boundary and visited
            if(new_i >= n || new_j >= m || new_i < 0 || new_j < 0 || matrix[new_i][new_j] != 0){

                curr_idx = (curr_idx + 1) % 4; // so idx doesnt go out of bound
                new_i = curr_i + dir[curr_idx][0];
                new_j = curr_j + dir[curr_idx][1];
            }
            curr_i = new_i;
            curr_j = new_j;
        }

        return matrix;
    }
}