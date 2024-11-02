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
    private Map<Integer, Integer> nodeHeight = new HashMap<>();  // Maps each node to its height
    private Map<Integer, Integer> nodeDepth = new HashMap<>();   // Maps each node to its depth
    private Map<Integer, List<Integer>> depthHeights = new HashMap<>();  // Maps depth to a list of subtree heights at that depth

    public int[] treeQueries(TreeNode root, int[] queries) {
        // Perform BFS to compute heights and depths
        computeHeightsAndDepthsBFS(root);

        // Populate the depthHeights map with heights at each depth
        for (int node : nodeHeight.keySet()) {
            int depth = nodeDepth.get(node);
            int height = nodeHeight.get(node);
            depthHeights.computeIfAbsent(depth, k -> new ArrayList<>()).add(height);
        }
        
        // Sort heights at each depth in descending order for easy access
        for (List<Integer> heights : depthHeights.values()) {
            Collections.sort(heights, Collections.reverseOrder());
        }
        
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int queryNode = queries[i];
            int depth = nodeDepth.get(queryNode);
            int height = nodeHeight.get(queryNode);
            
            // Find the maximum height after removing the subtree of the queried node
            List<Integer> heightsAtDepth = depthHeights.get(depth);
            int maxHeightAfterRemoval;
            if (heightsAtDepth.size() == 1) {
                maxHeightAfterRemoval = depth - 1; // If only one node at this depth, subtract its height
            } else if (heightsAtDepth.get(0) == height) {
                maxHeightAfterRemoval = depth + heightsAtDepth.get(1); // If highest height is removed, use the second highest
            } else {
                maxHeightAfterRemoval = depth + heightsAtDepth.get(0); // Otherwise, the highest is unaffected
            }
            
            result[i] = maxHeightAfterRemoval;
        }
        
        return result;
    }

    private void computeHeightsAndDepthsBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        nodeDepth.put(root.val, 0);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int depth = nodeDepth.get(node.val);
            
            int leftHeight = node.left != null ? height(node.left) : -1;
            int rightHeight = node.right != null ? height(node.right) : -1;
            int nodeHeightVal = Math.max(leftHeight, rightHeight) + 1;
            
            nodeHeight.put(node.val, nodeHeightVal);

            if (node.left != null) {
                queue.add(node.left);
                nodeDepth.put(node.left.val, depth + 1);
            }
            if (node.right != null) {
                queue.add(node.right);
                nodeDepth.put(node.right.val, depth + 1);
            }
        }
    }

    private int height(TreeNode node) {
        if (node == null) return -1;
        if (nodeHeight.containsKey(node.val)) return nodeHeight.get(node.val);
        
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        int nodeHeightVal = Math.max(leftHeight, rightHeight) + 1;
        
        nodeHeight.put(node.val, nodeHeightVal);
        return nodeHeightVal;
    }
}