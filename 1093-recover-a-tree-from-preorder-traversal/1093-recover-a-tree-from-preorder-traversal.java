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

// class Solution {
//     public TreeNode recoverFromPreorder(String traversal) {
//         List<int[]> nums = new ArrayList<>();
//         int n = traversal.length();
//         int i = 0, num = 0, hyphen = 0;
        
//         while (i < n) {
//             hyphen = 0;
//             while (i < n && traversal.charAt(i) == '-') {
//                 hyphen++;
//                 i++;
//             }
            
//             num = 0;
//             while (i < n && traversal.charAt(i) != '-') {
//                 num = (num * 10) + (traversal.charAt(i) - '0');
//                 i++;
//             }
            
//             nums.add(new int[]{num, hyphen});
//         }
        
//         if (nums.isEmpty()) return null;
//         int[] pointer = new int[]{0};
//         return dfs(nums, pointer, -1);
//     }
    
//     private TreeNode dfs(List<int[]> nums, int[] pointer, int prevLevel) {
//         if (pointer[0] == nums.size()) return null;
        
//         int[] cur = nums.get(pointer[0]);
//         int num = cur[0];
//         int level = cur[1];
        
//         if (level <= prevLevel) return null;
        
//         TreeNode root = new TreeNode(num);
//         pointer[0]++;
        
//         root.left = dfs(nums, pointer, level);
//         root.right = dfs(nums, pointer, level);
        
//         return root;
//     }
// }

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