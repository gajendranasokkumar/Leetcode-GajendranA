class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // R, D, L, U


        int curr_i = 0;
        int curr_j = 0;
        int curr_idx = 0;
        List<Integer> ans = new ArrayList<>();
        int maxi = n * m; // maximum number of ele will be rows X cols


        while(ans.size() < maxi){
            // add the curr ele in the arrayList
            ans.add(matrix[curr_i][curr_j]);

            // mark the ele as 1000 as range is (-100, 100)
            matrix[curr_i][curr_j] = 1000;

            // go in the same direction
            int new_i = curr_i + dir[curr_idx][0];
            int new_j = curr_j + dir[curr_idx][1];

            // check boundary and visited
            if(new_i >= n || new_j >= m || new_i < 0 || new_j < 0 || matrix[new_i][new_j] == 1000){

                curr_idx = (curr_idx + 1) % 4; // so idx doesnt go out of bound
                new_i = curr_i + dir[curr_idx][0];
                new_j = curr_j + dir[curr_idx][1];
            }
            curr_i = new_i;
            curr_j = new_j;
        }
        return ans;
    }
}