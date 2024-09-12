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
//     public List<List<Integer>> levelOrder(TreeNode root) 
//     {
//         List<List<Integer>>al=new ArrayList<>();
//         pre(root,0,al);
//         return al;
//     }
//     public static void pre(TreeNode root,int l,List<List<Integer>>al)
//     {
//         if(root==null)
//             return;
//         if(al.size()==l)
//         {
//             List<Integer>li=new ArrayList<>();
//             li.add(root.val);
//             al.add(li);
//         }
//         else
//             al.get(l).add(root.val);
//         pre(root.left,l+1,al);
//         pre(root.right,l+1,al);
//     } 
// }



class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue= new LinkedList<TreeNode>();
        List<List<Integer>> ans= new ArrayList<>();
        if(root == null) return ans;
        queue.offer(root);  // add root in queue
        while(!queue.isEmpty()){
            int currLevel= queue.size();
            List<Integer> temp= new ArrayList<>();
            for(int i=0; i< currLevel; i++){
                if(queue.peek().left != null) queue.offer(queue.peek().left);  // if curr has any left than add in queue
                if(queue.peek().right != null) queue.offer(queue.peek().right); // if curr has any right than add in queue
                temp.add(queue.poll().val);  // poll will add the curr val in queue and will remove from queue as well
            }
            ans.add(temp);
        }
        return ans;
    }

    // offer - add in queue
    // peek - will return the element and keep it in queue
    // poll - will return the elelement and remove it from the queue
}