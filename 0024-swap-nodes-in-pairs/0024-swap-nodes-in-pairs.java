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
    ListNode h = new ListNode(0);
    ListNode temp = h;
    public ListNode rev(ListNode head, int k){
        int count = 0;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while(curr != null && count <  k){
            count ++;
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        temp.next = prev;
        while(temp.next != null){
            temp = temp.next;
        }
        return next;
    }
    public ListNode swapPairs(ListNode head) {
        ListNode remaining = head;
        int k = 2;
        int count = 0;
        ListNode t = head;
        while(t != null){
            count++;
            t = t.next;
        }
        while(remaining != null && count >= k){
            remaining = rev(remaining, k);
            count -= k;
        }
        temp.next = remaining;
        return h.next;
    }
}