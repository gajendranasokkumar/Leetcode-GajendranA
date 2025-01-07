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
    public int maxLevelSum(TreeNode root) {
        int level = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int maxsum = Integer.MIN_VALUE, maxlevel = 1;
        while(!q.isEmpty()) {
            int n = q.size();
            int sum  = 0;
            while(n-- > 0) {
                TreeNode node = q.poll();
                sum += node.val;
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
            }
            // System.out.println(sum + " " + level);
            if(sum > maxsum) {
                maxsum = sum;
                maxlevel = level;
            }
            // System.out.println(maxsum);
            level++;
        }


        return maxlevel;
    }
}