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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if (preorder.length == 0)
            return null;
        
        int preIndex = 0, postIndex = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[preIndex++]);
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.val != postorder[postIndex]) {
                TreeNode child = new TreeNode(preorder[preIndex++]);
                if (node.left == null) {
                    node.left = child;
                } else {
                    node.right = child;
                }
                stack.push(child);
            } else {
                stack.pop();
                postIndex++;
            }
        }
        return root;
    }
}
