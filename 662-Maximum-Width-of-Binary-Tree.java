class Pair {
    int index;
    Pair(int i) {
        index = i;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(1));
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        int max = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int start = 0, end = 0;

            for (int i = 0; i < size; i++) {
                Pair current = queue.poll();
                TreeNode node = nodes.poll();
                
                if (i == 0) start = current.index; 
                if (i == size - 1) end = current.index;

                if (node.left != null) {
                    queue.add(new Pair(current.index * 2));
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    queue.add(new Pair(current.index * 2 + 1));
                    nodes.add(node.right);
                }
            }
            
            max = Math.max(max, end - start + 1);
        }

        return max;
    }
}
