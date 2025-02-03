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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode parent = findLCA(root, startValue, destValue);
        String leftPath =  findRightPath(parent, startValue, new StringBuilder());
        String rightPath =  findRightPath(parent, destValue, new StringBuilder());
        StringBuilder result = new StringBuilder();
        int size = leftPath.length();
        while(size-- > 0)
            result.append("U");
        result.append(rightPath);
        return result.toString();
    }
    public String findRightPath(TreeNode root, int val, StringBuilder path) {
        if(root.val == val)
            return path.toString();
        String left = "-1"; String right= "-1";
        if(root.left != null) {
            path.append("L");
            left = findRightPath(root.left, val, path);
            path.deleteCharAt(path.length() - 1);
        }
        if(root.right != null) {
            path.append("R");
            right = findRightPath(root.right, val, path);
            path.deleteCharAt(path.length() - 1);
        }
        return !left.equals("-1") ? left : right;
    }
    public TreeNode findLCA(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) {
            return root;
        }

        TreeNode left = findLCA(root.left, p, q);  
        TreeNode right = findLCA(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right; 
    }
}