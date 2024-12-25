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
    int total = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, "");
        return total; 
    }

    public void dfs(TreeNode root, String str) {
        if(root == null)
            return;

        str += String.valueOf(root.val);

        if(root.left == null && root.right == null){
            total += Integer.parseInt(str);
            return;
        }
        
        dfs(root.left, str);
        dfs(root.right, str);
    }
}