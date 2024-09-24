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
    public TreeNode inorder(TreeNode root){
        while(root.left!=null) root=root.left;
        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return root;

        if(root.val>key) root.left = deleteNode(root.left,key);
        else if(root.val<key) root.right = deleteNode(root.right,key);
        else{
            // Case 1---> when root is present only
            if(root.left==null && root.right==null) return null;
            // Case 2---> 1 Children in left or right
            if(root.left==null || root.right==null) return root.left==null?root.right:root.left;
            // Case-3---> 2 Children
            TreeNode x = inorder(root.right);
            root.val = x.val;
            root.right = deleteNode(root.right,x.val);
        }
        return root;
    }
}