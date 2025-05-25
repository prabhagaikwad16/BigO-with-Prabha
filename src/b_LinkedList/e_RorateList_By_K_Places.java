package b_LinkedList;

/*Given the head of a linked list, rotate the list to the right by k places.

Example 1:

Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]
Example 2:

Input: head = [0,1,2], k = 4
Output: [2,0,1]

Constraints:

The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109
*/


public class e_RorateList_By_K_Places {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode rotatedList = new e_RorateList_By_K_Places().rotateRight(head, 2);
        ListNode current = rotatedList;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || k == 0 || head.next == null) {
            return head;
        }

        // Initialize length = 1 to account for the head node and calculate the total length of the list
        int length = 1;
        ListNode dummy = head;
        while (dummy.next != null) {
            length++;
            dummy = dummy.next;
        }

        // Update k to k % length to handle cases where k >= length, then calculate the effective rotation
        
            /*Logic for k = length - (k % length):
            Handles cases where k >= length by reducing unnecessary rotations.
            k % length gives the effective rotations needed.
            Subtracting from length adjusts the rotation to the left-to-right direction.
            Condition if (k == length):
            If k equals the length of the list, the list remains unchanged, so return head.*/
        k = length - (k % length);
        if (k == length) {
            return head;
        }

        dummy.next = head; // Connect the tail to the head to form a circular list
        while (k != 0) {
            dummy = dummy.next;
            k--;
        }
        head = dummy.next; // Update the head to the new starting point
        dummy.next = null; // Break the circular connection to finalize the rotated list
        return head;
    }
}
