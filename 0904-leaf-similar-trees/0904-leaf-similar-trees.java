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
    List<Integer> left, right;
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        left = new ArrayList<>();
        right = new ArrayList<>();
        inorder(root1, true);
        inorder(root2, false);
        if(left.size() != right.size())
            return false;
        System.out.println(left);
        System.out.println(right);
        for(int i=0;i<left.size();i++) {
            if(!left.get(i).equals(right.get(i)))
                return false;
        }
        return  true;
    }
    public void inorder(TreeNode root, boolean one) {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
        {
            if(one) 
                left.add(root.val);
            else
                right.add(root.val);
            return;
        }
        inorder(root.left, one);
        inorder(root.right, one);
    }
}