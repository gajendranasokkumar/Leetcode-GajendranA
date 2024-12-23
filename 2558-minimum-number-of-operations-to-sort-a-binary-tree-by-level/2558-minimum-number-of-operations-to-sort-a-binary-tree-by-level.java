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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int swaps = 0;
        q.offer(root);
        while(!q.isEmpty()) {
            int n = q.size();
            int m = n;
            int[][] a = new int[n][2];
            int i=0;
            while(n-- > 0) {
                TreeNode node = q.poll();
                a[i][0] = node.val;
                a[i][1] = i;
                i++;

                if(node.left != null)
                    q.offer(node.left);
                if(node.right != null)
                    q.offer(node.right);
            }

            Arrays.sort(a, (k, l) -> k[0] - l[0]);
            boolean[] visited = new boolean[m];

            for(int o=0;o<m;o++) {
                if(visited[o] || a[o][1] == o) 
                    continue;
                
                int cycle = 0;
                int x = o;

                while(!visited[x]) {
                    visited[x] = true;
                    x = a[x][1];
                    cycle++;
                }

                if(cycle > 1) 
                    swaps += (cycle - 1);
            }

        }

        return swaps;
    }
}