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
    public int findDivisor(int one, int two)
    {
        if(one > two){
            int temp = one;
            one = two;
            two = temp;
        }
        int num = one;
        while(one > 0)
        {
            if(num%one==0 && two%one==0)
                return one;
            one--;
        }
        return one;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode temp = head;
        while(temp != null && temp.next != null)
        {
            int num1 = temp.val;
            int num2 = temp.next.val;
            int div = findDivisor(num1, num2);
            ListNode newnode = new ListNode(div);
            ListNode newtemp = temp.next;
            temp.next = newnode;
            temp = temp.next;
            temp.next = newtemp;
            temp = temp.next;
        }


        return head;
    }
}