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
    public HashSet<Integer> set;
    public int count =0;
    public int target;
    public void fun(TreeNode root){
        if(root == null){
            return ;
        }
        if(set.contains(root.val)){
            count ++;
        }
        set.add(target - root.val);
        fun(root.left);
        fun(root.right);
    }
    public boolean findTarget(TreeNode root, int k) {
        set = new HashSet<>();
        target = k;
        fun(root);
        // System.out.println(set);
        return count>0 ? true : false;
        
    }
}