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
    public TreeNode replaceValueInTree(TreeNode root) {
        Map<Integer, Integer> levelsum = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            while(size-- > 0) {
                TreeNode temp = q.poll();
                sum += temp.val;

                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
            levelsum.put(level++, sum);
        }

        q.add(root);
        level = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            int sum = 0;

            while(size-- > 0) {
                TreeNode temp = q.poll();
                sum = 0;
                if(temp.left != null) {
                    q.add(temp.left);
                    sum += temp.left.val;
                }
                    
                if(temp.right != null) {
                    q.add(temp.right);
                    sum += temp.right.val;
                }


                if(temp.left != null) {
                    temp.left.val = levelsum.get(level+1) - sum;
                }
                    
                if(temp.right != null) {
                    temp.right.val = levelsum.get(level+1) - sum;
                }

            }
            level++;
        }


        root.val = 0;

        return root;
    }
}