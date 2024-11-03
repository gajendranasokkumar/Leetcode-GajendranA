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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root,targetSum,0);
    }
    public boolean helper(TreeNode root,int target,int curSum){
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return curSum + root.val == target;
        }
        return helper(root.left,target,curSum + root.val) || helper(root.right,target,curSum + root.val);
    }
}