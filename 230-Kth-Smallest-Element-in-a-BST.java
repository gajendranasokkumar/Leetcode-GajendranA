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
    int result;
    int num;

    public int kthSmallest(TreeNode root, int k) {
        result = 0;
        num = k;
        inorder(root);
        return result;
    }

    private void inorder(TreeNode root) {
        if (root == null)
            return;
        
        inorder(root.left);
        num --;
        if (num == 0) {
            result = root.val;
            return;
        }
        
        inorder(root.right);
    }
}