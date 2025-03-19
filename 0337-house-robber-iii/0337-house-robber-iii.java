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
    public int rob(TreeNode root) {
        Map<TreeNode, int[]> dp = new HashMap<>();
        return robTree(root, 1, dp);
    }

    public int robTree(TreeNode root, int canRob, Map<TreeNode, int[]> dp) {
        if (root == null) 
            return 0;

        if (dp.containsKey(root) && dp.get(root)[canRob] != -1) 
            return dp.get(root)[canRob];

        int[] memo = dp.getOrDefault(root, new int[]{-1, -1});
        
        int max;
        if (canRob == 1) {
            max = Math.max(root.val + robTree(root.left, 0, dp) + robTree(root.right, 0, dp),
                           robTree(root.left, 1, dp) + robTree(root.right, 1, dp));
        } else {
            max = robTree(root.left, 1, dp) + robTree(root.right, 1, dp);
        }

        memo[canRob] = max;
        dp.put(root, memo);
        return max;
    }
}
