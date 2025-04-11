package b_LinkedList;

/*Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.



Example 1:


Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.
Example 2:


Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.


Constraints:

The number of nodes in the list is in the range [1, 100].
1 <= Node.val <= 100*/
public class b_Middle_Of_LinkedList {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        b_Middle_Of_LinkedList middleOfLinkedList = new b_Middle_Of_LinkedList();
        ListNode middleNode = middleOfLinkedList.middleNode(head);
        System.out.println("Middle Node: " + middleNode.val); // Output: 3
    }

    // Returns the middle node of the linked list
    public ListNode middleNode(ListNode head) {

        ListNode slow = head; // Moves one step at a time
        ListNode fast = head; // Moves two steps at a time

        // Traverse the list until fast pointer reaches the end
        while(fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer
            fast = fast.next.next; // Move fast pointer
        }

        return slow; // Slow pointer will be at the middle
    }
}


