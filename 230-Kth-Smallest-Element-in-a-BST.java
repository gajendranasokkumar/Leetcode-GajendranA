/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private int counter = 1;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return -1;
        int l = kthSmallest(root.left, k);
        if(l>=0) return l;
        if (k==counter) return root.val;
        counter++;
        int r = kthSmallest(root.right, k);
        if(r>=0) return r;
        return -1;
    }
}