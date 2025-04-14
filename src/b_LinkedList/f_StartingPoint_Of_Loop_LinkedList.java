package b_LinkedList;

public class f_StartingPoint_Of_Loop_LinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // Create a cycle for testing
        ListNode startingPoint = new f_StartingPoint_Of_Loop_LinkedList().detectCycle(head);
        if (startingPoint != null) {
            System.out.println("Cycle starts at node with value: " + startingPoint.val);
        } else {
            System.out.println("No cycle detected.");
        }

    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null; // No cycle
        }

        ListNode slow = head;
        ListNode fast = head;

        // Detect if a cycle exists using two pointers
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Cycle detected
            if (slow == fast) {
                // Find the starting point of the cycle
                fast = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // Starting point of the cycle
            }
        }

        return null; // No cycle
    }
}
