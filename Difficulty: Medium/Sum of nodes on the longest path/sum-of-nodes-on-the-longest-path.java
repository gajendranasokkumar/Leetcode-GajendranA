class Solution {
    public int sumOfLongRootToLeafPath(Node root) {
        int maxLevel = 0;
        int maxSum = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, root.data, 1));
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            Node node = pair.ele;
            int cursum = pair.sum;
            int curlevel = pair.level;
            if (node.left == null && node.right == null) {
                if (curlevel > maxLevel || (curlevel == maxLevel && cursum > maxSum)) {
                    maxLevel = curlevel;
                    maxSum = cursum;
                }
            }
            if (node.left != null) {
                q.add(new Pair(node.left, cursum + node.left.data, curlevel + 1));
            }
            if (node.right != null) {
                q.add(new Pair(node.right, cursum + node.right.data, curlevel + 1));
            }
        }
        return maxSum;
    }
}

class Pair {
    Node ele;
    int sum, level;
    public Pair(Node _ele, int _sum, int _level) {
        ele = _ele;
        sum = _sum;
        level = _level;
    }
}
