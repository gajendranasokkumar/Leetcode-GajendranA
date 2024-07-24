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


 public ListNode mergeTwoLists(ListNode a, ListNode b) {
        if(a==null)return b;
        if(b==null)return a;
        ListNode head=null,tail=null;
        if(a.val<=b.val){
            head=tail=a;
            a=a.next;
        }
        else{
            head=tail=b;
            b=b.next;
        }
        while(a!=null && b!=null){
            if(a.val<=b.val){
                tail.next=a;
                tail=a;
                a=a.next;
            }
            else{
                tail.next=b;
                tail=b;
                b=b.next;
            }
        }
        if(a==null){
            tail.next=b;
        }
        else{
            tail.next=a;
        }
        return head;
    }

    public ListNode findMid(ListNode head){
        ListNode slow=head,fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)return head;

        ListNode mid=findMid(head);
        ListNode left=head;
        ListNode right=mid.next;
        mid.next=null;

        left=sortList(left);
        right=sortList(right);

        ListNode res=mergeTwoLists(left,right);
        return res;
    }
}