/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp = head;
        Node newlist = new Node(0), t=newlist;
        while(temp != null)
        {
            t.next = new Node(temp.val);
            t=t.next;
            temp=temp.next;
        }
        temp = head;
        t = newlist.next;
        while(temp != null)
        {
            int count = 0;
            Node search = temp.random, s = head;
            if(search != null)
            {
                while(s != null && s != search)
                {
                    count++;
                    s = s.next;
                }
                Node point = newlist;
                while(count >= 0)
                {
                    point = point.next;
                    count--;
                }

                t.random = point;
            }
            else
            {
                t.random = null;
            }

            temp = temp.next;
            t = t.next;
        }
        return newlist.next;
    }
}