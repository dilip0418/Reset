package LinkedList;

public class SegregateOddAndEvenPositionedNodes {
    public static void main(String[] args) {

        int[] nodes = { 1, 2, 3, 4, 5 };
        // int[] nodes = { 1, 2, 3, 4, 5, 6 };
        ListNode head = RemoveDuplicates.createLinkedList(nodes);

        RemoveDuplicates.printList(segregateOddAndEvenPositionedNodes(head));
    }

    private static ListNode segregateOddAndEvenPositionedNodes(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode odd = head;
        ListNode evenHead = head.next;

        ListNode even = evenHead;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }
}
