/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxi = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        findMax(root, 0, true);
        findMax(root, 0, false);
        return maxi;
    }

    public void findMax(TreeNode root, int length, boolean isLeft) {
        if (root == null) {
            return;
        }
        maxi = Math.max(maxi, length);
        if (isLeft) {
            findMax(root.right, length + 1, false);
            findMax(root.left, 1, true);
        } else {
            findMax(root.left, length + 1, true);
            findMax(root.right, 1, false);
        }
    }
}
