package b_LinkedList;

public class c_Remove_Nth_Node_From_Back_LinkedList {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        c_Remove_Nth_Node_From_Back_LinkedList removeNthNode = new c_Remove_Nth_Node_From_Back_LinkedList();

        ListNode resultHead = removeNthNode.removeNthFromEnd(head, 2);
        System.out.print("Updated List: ");
        while (resultHead != null) {
            System.out.print(resultHead.val + " ");
            resultHead = resultHead.next;
        }

    }

    //1,2,3,4,5
    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Dummy node is used to handle edge cases like removing the first node
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode slow = dummy; // Slow pointer starts at dummy
        ListNode fast = dummy; // Fast pointer starts at dummy

        // Move the fast pointer n steps ahead
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the nth node from the end
        slow.next = slow.next.next;

        // Return the updated list starting from the original head
        return dummy.next;
    }
}
