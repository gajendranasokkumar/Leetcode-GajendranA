/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    // public List<Integer> fun(ListNode l1, ListNode l2, int rem)
    // {
    // if(l1.next == null && l2.next == null)
    // {
    // int sum = l1.val + l2.val;
    // int remainder = sum % 10;
    // return Arrays.asList((int)sum/10, remainder);
    // }
    // else if(l1.next == null)
    // {
    // return fun(l1, l2.next, rem);
    // }
    // else if(l2.next == null)
    // {
    // return fun()
    // }
    // }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // int rem = 0;
        // long total = 0;
        // ListNode newList = null;
        // ListNode temp = newList;
        // int sum=0;
        // while (l1 != null && l2 != null) {
        //     sum = l1.val + l2.val + rem;
        //     rem = (sum / 10) % 10;
        //     total = total * 10 + (sum % 10);
        //     l1 = l1.next;
        //     l2 = l2.next;
        //     ListNode one = new ListNode((int)total % 10);
        //     if (newList == null) {
        //         newList = one;
        //         temp = one;
        //     } else {
        //         temp.next = one;
        //         temp = temp.next;
        //     }
        // }

        // while (l1 != null) {
        //     sum = l1.val + rem;
        //     System.out.println(rem);
        //     rem = (sum / 10) % 10;
        //     total = total * 10 + (sum % 10);
        //     l1 = l1.next;
        //     ListNode one = new ListNode((int)total % 10);
        //     temp.next = one;
        //     temp = temp.next;
        // }

        // while (l2 != null) {
        //     sum = l2.val + rem;
        //     rem = (sum / 10) % 10;a
        //     total = total * 10 + (sum % 10);
        //     l2 = l2.next;
        //     ListNode one = new ListNode((int)total % 10);
        //     temp.next = one;
        //     temp = temp.next;
        // }
        // total = total * 10 + (rem % 10);
        // System.out.println(total);
        // if (rem != 0 ) {
        //     ListNode one = new ListNode((int)total % 10);
        //     temp.next = one;
        //     temp = temp.next;
        // }
        // return newList;

        int carry = 0;
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummyHead.next;

    }
}