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
    int count = 0;
    public int goodNodes(TreeNode root) {
        max(root, Integer.MIN_VALUE);
        return count;
    }
    public void max(TreeNode root, int prev) {
        if(root == null)
            return;
        
        if(prev <= root.val)
            count++;
        
        max(root.left, Math.max(root.val, prev));
        max(root.right, Math.max(root.val, prev));
    }
}