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
        if(head == null) return head;

        Node temp = head;

        while(temp != null) {
            Node newNode = new Node(temp.val);
            Node t = temp.next;
            temp.next = newNode;
            newNode.next = t;
            temp = newNode.next;
        }

        Node h1 = head;
        Node h2 = head.next;

        while(h1 !=  null) {
            if(h1.random != null) h2.random = h1.random.next;
            h1 = h1.next.next;
            if(h1 != null) h2 = h1.next;
        }

        h1 = head;
        Node ans = head.next;
        h2 = head.next;

        while(h1 != null) {
           h1.next = h2.next;
           h1 = h1.next;
           if(h1 != null) {
            h2.next = h1.next;
            h2 = h2.next;
           }
        }
        return ans;
    }
}