// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
// class Solution {
//     public ListNode reverseList(ListNode head) {
//         ListNode curr = head;
//         ListNode prev = null;

//         while (curr != null) {
//             ListNode nextNode = curr.next;
//             curr.next = prev;
//             prev = curr;
//             curr = nextNode;
//         }
//         return prev;
//     }

//     public boolean isPalindrome(ListNode head) {
//         ListNode reversed = reverseList(head);
//         while(head != null)
//         {
//             if(head.val != reversed.val)
//                 return false;

//             head = head.next;
//             reversed = reversed.next;
//         }

//         return true;
//     }
// }


class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        // Edge case: empty list or single element
        if (head == null || head.next == null) return true;

        // Reverse the entire list (your method)
        ListNode reversed = reverseList(copyList(head));

        // Compare the original list with the reversed list
        while (head != null && reversed != null) {
            if (head.val != reversed.val) return false;
            head = head.next;
            reversed = reversed.next;
        }

        return true;
    }

    private ListNode copyList(ListNode head) {
        if (head == null) return null;
        ListNode newHead = new ListNode(head.val);
        ListNode current = newHead;
        ListNode originalCurrent = head.next;

        while (originalCurrent != null) {
            current.next = new ListNode(originalCurrent.val);
            current = current.next;
            originalCurrent = originalCurrent.next;
        }

        return newHead;
    }
}