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
    private static int maxi=0;
    public static int diameter_helper(TreeNode root)
    {
        if(root==null) return 0;
        int lh=diameter_helper(root.left);
        int rh=diameter_helper(root.right);
        maxi=Math.max(maxi, lh+rh);
        return 1+Math.max(lh, rh);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        maxi=0;
        diameter_helper(root);
        return maxi;
    }


}