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
        // Write your code here
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

    public static void main(String[] args) {
        ListNode list1 = createLinkedList(new int[] { 3, 3, 4, 5, 5 });

        printList(removeDuplicates(list1));
    }
}