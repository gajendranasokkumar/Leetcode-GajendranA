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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        int index = 0;
        ListNode odd, even, temp = new ListNode(0);
        odd = head;
        even = head.next;
        ListNode result = even;
        while(even != null && even.next != null)
        {
            odd.next = even.next;
            odd = even.next;
            even.next = odd.next;
            even = odd.next;
        }

        odd.next = result;

        return head;
    }
}