package b_LinkedList;

// Definition of a singly linked list node
class ListNode {
    int val; // Value of the node
    ListNode next; // Pointer to the next node
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
