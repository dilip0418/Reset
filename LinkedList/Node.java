package LinkedList;

public class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node() {
    }

    public Node createList(int[] nodes) {
        Node head = new Node();
        Node newNode = head;
        for (int i : nodes) {
            if (head.data != 0) {
                Node curr = new Node(i);
                newNode.next = curr;
                newNode = newNode.next;
            }
        }
        return newNode;
    }

    
}