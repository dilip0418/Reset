package LinkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    public ListNode() {
    }
}

public class Merge2SortedList {

    public static ListNode createLinkedList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : arr) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    public static ListNode mergeLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        }
        if (list2 != null) {
            current.next = list2;
        }
        return dummy.next;
    }

    public static void printList(ListNode head) {
        System.out.print("Head->");
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("Null");
    }

    public static void main(String[] args) {

        // Test Case 1
        ListNode list1 = createLinkedList(new int[] { 1, 3, 5 });
        ListNode list2 = createLinkedList(new int[] { 2, 4, 6 });
        ListNode test1 = mergeLists(list1, list2);
        printList(test1);
        // Expected output: 1 -> 2 -> 3 -> 4 -> 5 -> 6

        // Test Case 2
        ListNode list3 = createLinkedList(new int[] { 1, 2, 4 });
        ListNode list4 = createLinkedList(new int[] { 1, 3, 4 });
        ListNode test2 = mergeLists(list3, list4);
        printList(test2);
        // Expected output: 1 -> 1 -> 2 -> 3 -> 4 -> 4

        // Test Case 3
        ListNode list5 = createLinkedList(new int[] {});
        ListNode list6 = createLinkedList(new int[] { 0 });
        ListNode test3 = mergeLists(list5, list6);
        printList(test3);
        // Expected output: 0
    }
}
