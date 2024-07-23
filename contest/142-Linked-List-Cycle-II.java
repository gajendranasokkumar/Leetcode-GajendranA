/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>();
        int index = 0;
        while(head != null)
        {
            if(map.containsKey(head))
            {
                return head;
            }
            else
            {
                map.put(head, index++);
            }

            head = head.next;
        }

        return null;
    }
}