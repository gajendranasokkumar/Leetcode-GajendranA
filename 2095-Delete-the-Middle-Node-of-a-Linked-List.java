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
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null; 
        }
        int count = 0;
        ListNode temp = head;
        ListNode last = head;

        while(temp != null) 
        {
            temp = temp.next;
            count++;
        }


        for(int i=0;i<count/2-1;i++)
        {
            last = last.next;
        }

        last.next = last.next.next;

        return head;
    }
}