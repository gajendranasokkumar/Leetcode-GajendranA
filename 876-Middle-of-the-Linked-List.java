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
    private int countNodes(ListNode head) {
        if (head == null) {
            return 0;
        }
        return 1 + countNodes(head.next);
    }

    private ListNode findMiddle(ListNode head, int middleIndex, int currentIndex) {
        if (currentIndex == middleIndex) {
            return head;
        }
        return findMiddle(head.next, middleIndex, currentIndex + 1);
    }

    public ListNode middleNode(ListNode head) {
        int totalNodes = countNodes(head);
        int middleIndex = totalNodes / 2;
        return findMiddle(head, middleIndex, 0);
    }
}