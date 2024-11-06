/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return build(grid, 0, 0, grid.length - 1, grid[0].length - 1);
    }

    public Node build(int[][] grid, int row1, int col1, int row2, int col2) {
        if (row1 == row2 && col1 == col2)
            return new Node(grid[row1][col1] == 1, true);

        int midRow = (row1 + row2) / 2;
        int midCol = (col1 + col2) / 2;

        Node topLeft = build(grid, row1, col1, midRow, midCol);
        Node topRight = build(grid, row1, midCol + 1, midRow, col2);
        Node bottomLeft = build(grid, midRow + 1, col1, row2, midCol);
        Node bottomRight = build(grid, midRow + 1, midCol + 1, row2, col2);

        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf &&
                topLeft.val == topRight.val && topLeft.val == bottomLeft.val && topLeft.val == bottomRight.val) {
            return new Node(topLeft.val, true);
        }

        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    // public int[] check(int[][] grid, int row1, int col1, int row2, int col2) {
    // boolean isLeaf = false;
    // boolean val = false;

    // int init = grid[row1][col1];
    // for(int i=row1;i<=row2;i++) {
    // for(int j=col1;j<=col2;j++) {
    // if(grid[i][j] != init) {
    // return new int[]{-1, -1};
    // }
    // }
    // }

    // val = init == 0 ? false : true;
    // return new int[]{val, isLeaf};
    // }
}
