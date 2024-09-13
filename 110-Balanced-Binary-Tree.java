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

    public int height(TreeNode temp)
    {
        if(temp == null)
            return -1;
        else
        {
            int left = height(temp.left);
            int right = height(temp.right);
            if(left > right)
                return left+1;
            else 
                return right+1;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int left = height(root.left)+1;
        int right = height(root.right)+1;
        System.out.println(left + \ \ + right);
        if (Math.abs(left - right) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
}