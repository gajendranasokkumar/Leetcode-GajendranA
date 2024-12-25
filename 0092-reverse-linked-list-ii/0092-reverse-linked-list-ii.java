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
    ListNode root = new ListNode(0);
    ListNode temp = root;
    public void rev(ListNode node, int start, int end) {
        ListNode prev = null;
        ListNode cur = node;
        ListNode next = null;
        while(start <= end) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            start++;
        }
        temp.next = prev;
        while(temp.next != null)
            temp = temp.next;

        temp.next = cur;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        root.next = head;
        temp = root;
        int i=1;
        while(i < left) {
            temp = temp.next;
            i++;
        }

        rev(temp.next, left, right);

        return root.next;
    }
}