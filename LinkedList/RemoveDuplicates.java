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

public class RemoveDuplicates {

    public static ListNode createLinkedList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : arr) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    public static ListNode removeDuplicates(ListNode llist) {
        ListNode curr = llist;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return llist;

    }

    public static void printList(ListNode head) {
        System.out.print("Head->");
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("Null");
    }

    public static ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null)
            return new ListNode(-1);
        ListNode prev = null;
        ListNode t = head;
        ListNode h = head;

        while (h != null && h.next != null) {
            prev = t;
            t = t.next;
            h = h.next.next;
        }

        prev.next = t.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode list1 = createLinkedList(new int[] { 3, 3, 4, 5, 5 });
        // ListNode list1 = createLinkedList(new int[] { 1, 2, 3, 4, 5 });

        System.out.println("Duplicates removed:");
        printList(removeDuplicates(list1));
        System.out.println("Middle element removed:");
        printList(deleteMiddle(list1));
    }
}