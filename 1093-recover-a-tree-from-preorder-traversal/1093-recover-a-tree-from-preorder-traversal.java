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
    public TreeNode recoverFromPreorder(String traversal) {
        List<int[]> nums = new ArrayList<>();
        int n = traversal.length();
        int i=0;
        int num=0, hypen=0;
        char c = traversal.charAt(i);
        while(i < n && c != '-') {
            num = (num * 10) + (c - '0');
            i++;
            if(i < n)
                c = traversal.charAt(i);
        }
        nums.add(new int[]{num, 0});
        while(i < n) {
            hypen = num = 0;
            c = traversal.charAt(i);
            while(i < n && c == '-') {
                hypen++;
                c = traversal.charAt(i);
                i++;
            }
            i--;
            c = traversal.charAt(i);
            while(i < n && c != '-') {
                num = (num * 10) + (c - '0');
                i++;
                if(i < n)
                    c = traversal.charAt(i);
            }
            nums.add(new int[]{num, hypen-1});
        }

        if(nums.size() == 0)
            return null;

        Stack<Pair> stack = new Stack<>();
        TreeNode root = new TreeNode(nums.get(0)[0]);
        int pointer = 1;
        n = nums.size();
        stack.push(new Pair(root, 0));
        while(pointer < n) {
            int[] cur = nums.get(pointer);
            num = cur[0];
            int lvl = cur[1];
            TreeNode top = stack.peek().node;
            int level = stack.peek().level;
            TreeNode newnode = new TreeNode(num);
            if(level < lvl) {
                top.left = newnode;
            } else {
                while(level >= lvl) {
                    stack.pop();
                    level = stack.peek().level;
                }
                top = stack.peek().node;
                top.right = newnode;
            }
            stack.push(new Pair(newnode, lvl));
            pointer++;
        }
        return root;
    }
}

class Pair {
    int level;
    TreeNode node;
    public Pair(TreeNode _node, int _level)  {
        node = _node;
        level = _level;
    }
}