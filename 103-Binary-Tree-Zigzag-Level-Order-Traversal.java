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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        queue.offer(root);
        boolean flag = false;
        while(!queue.isEmpty())
        {
            int currentLvl = queue.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<currentLvl;i++)
            {
                if(queue.peek().left != null)
                    queue.offer(queue.peek().left);
                if(queue.peek().right != null)
                    queue.offer(queue.peek().right);
                temp.add(queue.poll().val);
            }
            if(flag)
                Collections.reverse(temp);
            flag = !flag;
            result.add(temp);
        }
        
        return result;
    }
}