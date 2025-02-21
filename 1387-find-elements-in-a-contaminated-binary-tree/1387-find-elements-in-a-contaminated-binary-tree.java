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
class FindElements {
    Set<Integer> set;
    public FindElements(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        set = new HashSet<>();
        q.add(root);
        boolean flag = false;
        while(!q.isEmpty()) {
            TreeNode cur = q.poll();
            if(!flag) {
                cur.val = 0;
                flag = true;
            }
            int val = cur.val;
            set.add(val);
            if(cur.left != null) {
                cur.left.val = (val * 2) + 1;
                q.add(cur.left);
            }
            if(cur.right != null) {
                cur.right.val = (val * 2) + 2;
                q.add(cur.right);
            }
        }
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */