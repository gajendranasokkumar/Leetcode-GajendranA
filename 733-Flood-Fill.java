class Solution {
    int rows;
    int cols;
    int originalColor;
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows = image.length;
        cols = image[0].length;
        originalColor = image[sr][sc]; 
        
        if (originalColor == color) {
            return image;
        }
        
        bfs(image, sr, sc, color);
        return image;
    }
    
    public void bfs(int[][] image, int row, int col, int color) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || image[row][col] != originalColor) {
            return;
        }
        
        image[row][col] = color;
        
        bfs(image, row - 1, col, color);
        bfs(image, row + 1, col, color); 
        bfs(image, row, col - 1, color); 
        bfs(image, row, col + 1, color); 
    }
}
