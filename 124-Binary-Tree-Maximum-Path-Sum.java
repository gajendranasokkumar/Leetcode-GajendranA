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
    //initialise a class level max variable
     int max= Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        if(root==null)
        return 0;

        sum(root);
        return max;
    
    }

    public int sum(TreeNode root)
    {
        //for leaf node, sum contribution=0
        if(root==null)
        return 0;
        //if negative, will never contribute to max sum, so ignore
        int lsum= Math.max(sum(root.left),0);
        int rsum= Math.max(sum(root.right),0);
        
        //sum at self node will be sum of all
        int self= root.val+rsum+lsum; 
        max= Math.max(max,self);
        //now if we have to go up a node, contribution will come from any one side left or right
        return Math.max(rsum,lsum)+root.val;
    }
}