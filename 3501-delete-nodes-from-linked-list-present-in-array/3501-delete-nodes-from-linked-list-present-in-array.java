/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode newhead = new ListNode(0);
        ListNode temp = newhead;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        while(head != null) {
            if(!set.contains(head.val)) {
                temp.next = new ListNode(head.val);
                temp = temp.next; 
            }
            head = head.next;
        }

        return newhead.next; 
    }
}