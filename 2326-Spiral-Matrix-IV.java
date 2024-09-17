/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n]; // Create m x n matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = -1; // Fill the matrix with -1
            }
        }

        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // Directions for spiral: right, down, left, up
        int curr_i = 0, curr_j = 0, curr_idx = 0;

        while (head != null) {
            matrix[curr_i][curr_j] = head.val; // Fill current position with linked list value
            head = head.next;

            // Calculate next position
            int new_i = curr_i + dir[curr_idx][0];
            int new_j = curr_j + dir[curr_idx][1];

            // Check if new position is out of bounds or already visited
            if (new_i < 0 || new_i >= m || new_j < 0 || new_j >= n || matrix[new_i][new_j] != -1) {
                curr_idx = (curr_idx + 1) % 4; // Change direction
                new_i = curr_i + dir[curr_idx][0];
                new_j = curr_j + dir[curr_idx][1];
            }

            curr_i = new_i;
            curr_j = new_j;
        }

        return matrix;
    }
}
