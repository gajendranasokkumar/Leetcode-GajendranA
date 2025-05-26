/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
} */

class Solution {
    public Node sortedInsert(Node head, int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        
        Node tail = head;
        while (tail.next != head)
            tail = tail.next;
        
        if (data <= head.data || data >= tail.data) {
            tail.next = newNode;
            newNode.next = head;
            if (data <= head.data)
                return newNode;
            else
                return head;
        }
        
        Node curr = head;
        while (curr.next != head && curr.next.data < data)
            curr = curr.next;
        
        newNode.next = curr.next;
        curr.next = newNode;
        return head;
    }
}
