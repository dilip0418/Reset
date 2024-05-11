package LinkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class RemoveNthNodeFromEnd {

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    private static ListNode removeNthNodeFromEnd(ListNode head, int n) {
        ListNode slow = head, fast = head;
        ListNode prev = head;
        int posi = 1;
        while (posi < n) {
            fast = fast.next;
            posi++;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            System.out.println(slow.val);
        }
        prev.next = slow.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;

        printList(removeNthNodeFromEnd(n1, 2));
    }
}
