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
    public int pairSum(ListNode head) {
        int n = 0;
        ListNode temp = head;
        while(temp != null) {
            n++;
            temp = temp.next;
        }
        temp = head;
        for(int i=0;i<n/2;i++) 
            temp = temp.next;
        ListNode rem = reverse(temp);
        ListNode cur = head;
        int maxi = 0;
        while(rem != null) {
            // System.out.println(rem.val);
            maxi = Math.max(maxi, cur.val + rem.val);
            cur = cur.next;
            rem = rem.next;
        }

        return maxi;
    }
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        while(cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}