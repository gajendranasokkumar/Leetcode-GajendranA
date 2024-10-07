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
    int ans=0;
    public void help(TreeNode root,int sum){
        if(root==null)  return;
        sum=sum*2 + root.val;
        help(root.left,sum);
        if(root.left==null&&root.right==null)    
            ans+=sum;
        help(root.right,sum);
        sum /= 2;
    }
    public int sumRootToLeaf(TreeNode root) {
        help(root,0);
        return ans;
    }
}