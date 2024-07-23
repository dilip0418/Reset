package LinkedList;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node() {
    }
}

public class ReverseLinkedList {
    public static void main(String[] args) {
        // create a linked list and add four nodes to it
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.next = n2;
        Node n3 = new Node(3);
        n2.next = n3;
        Node n4 = new Node(4);
        n3.next = n4;
        n4.next = null;

        printLinkedList(n1);

        Node newHead = reverseLinkedList(n1);

        printLinkedList(newHead);
    }

    private static Node reverseLinkedList(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node front = curr.next;
            curr.next = prev;
            prev = curr;
            curr = front;
        }

        return prev;
    }

    private static void printLinkedList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
