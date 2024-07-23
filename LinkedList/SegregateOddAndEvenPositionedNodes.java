package LinkedList;

public class SegregateOddAndEvenPositionedNodes {
    public static void main(String[] args) {

        int[] nodes = { 1, 2, 3, 4, 5 };
        // int[] nodes = { 1, 2, 3, 4, 5, 6 };
        ListNode head = RemoveDuplicates.createLinkedList(nodes);

        RemoveDuplicates.printList(segregateOddAndEvenPositionedNodes(head));
    }

    private static ListNode segregateOddAndEvenPositionedNodes(ListNode head) {
        // check the case where there is only one node or empty list
        if (head == null || head.next == null)
            return head;

        // use node to traverse and rearrange the nodes
        ListNode evenHead = head.next;
        ListNode odd = head;

        ListNode even = evenHead;

        // as the even node is forward iterate until it or it's next node is null
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        // finally point the last node in the odd set of nodes to evenHead
        odd.next = evenHead;
        return head;
    }
}
