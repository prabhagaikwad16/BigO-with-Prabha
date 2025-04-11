package b_LinkedList;

/*Given the head of a singly linked list, reverse the list, and return the reversed list.



Example 1:

Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
Example 2:


Input: head = [1,2]
Output: [2,1]
Example 3:

Input: head = []
Output: []


Constraints:

The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000
 */

public class a_ReverseLinkedList {
    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Reverse the linked list
        a_ReverseLinkedList reverseLinkedList = new a_ReverseLinkedList();
        ListNode reversedHead = reverseLinkedList.reverseList(head);

        // Print the reversed linked list
        ListNode current = reversedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

    // Reverses a singly linked list
    public ListNode reverseList(ListNode head) {
        ListNode dummy = null; // New head of the reversed list
        ListNode next;

        // Traverse the list and reverse the links
        while (head != null) {
            next = head.next; // Store the next node
            head.next = dummy; // Reverse the link
            dummy = head; // Move dummy to the current node
            head = next; // Move to the next node
        }

        return dummy; // Return the new head of the reversed list
    }
}

