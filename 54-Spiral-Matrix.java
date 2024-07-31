class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> li = new ArrayList<>();
        rotate(matrix,li,matrix.length,matrix[0].length,0,-1,0,1);
        return li;
    }
    public void rotate(int[][] matrix,List<Integer> li,int nr,int nc,int r,int c,int dr,int dc){
        if(nr==0 || nc==0) return;
        for(int i=0;i<nc;i++){
            r+=dr;
            c+=dc;
            li.add(matrix[r][c]);
        }
        rotate(matrix,li,nc,nr-1,r,c,dc,-dr);
    }
}