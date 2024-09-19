/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> list = new ArrayList<>();
        check(root, p, q, list);
        if (list.size() != 0) {
            return list.get(list.size() - 1); 
        }
        return root;
    }

    public boolean check(TreeNode root, TreeNode p, TreeNode q, ArrayList<TreeNode> list) {
        if (root == null) {
            return false;
        }
        
        boolean left = check(root.left, p, q, list);  
        boolean right = check(root.right, p, q, list);
        
        boolean mid = (root == p || root == q);
        
        if ((mid && left) || (mid && right) || (left && right)) {
            list.add(root);  
        }

        return mid || left || right;
    }
}
