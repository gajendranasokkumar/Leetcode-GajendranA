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

class NodeLevel {
    int level;
    TreeNode node;
    public NodeLevel(int l, TreeNode n) {
        this.level = l;
        this.node = n;
    }
}
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(root);
        while(!queue1.isEmpty()) {
            while(queue1.size() > 1)
                queue2.add(queue1.poll());
            TreeNode temp = queue1.poll();
            list.add(temp.val);
            queue2.add(temp);
            while(!queue2.isEmpty()) {
                TreeNode cur = queue2.poll();
                if(cur.left != null)
                    queue1.add(cur.left);
                if(cur.right != null)
                    queue1.add(cur.right);
            }
        }

        return list;
    }
}