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
    public int gcd(int a, int b){
        if(a == 1 || b==1){
            return 1;
        }
        while(b !=0){
            int rem = a % b;
            a = b;
            b= rem;
        }
        return a;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode temp = head;
        while(temp != null && temp.next != null)
        {
            int num1 = temp.val;
            int num2 = temp.next.val;
            int div = gcd(num1, num2);
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