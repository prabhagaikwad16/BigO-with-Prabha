package b_LinkedList;

public class g_Delete_Node_LinkedList {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        g_Delete_Node_LinkedList deleteNodeLinkedList = new g_Delete_Node_LinkedList();
        System.out.println("Before deletion: ");
        deleteNodeLinkedList.printLinkedList(head);
        deleteNodeLinkedList.deleteNode(head.next.next.next);
        System.out.println("After deletion: ");
        deleteNodeLinkedList.printLinkedList(head);
    }

    // Deletes the given node (except the last node)
    public void deleteNode(ListNode node) {
        // Copy the value of the next node to the current node
        node.val = node.next.val;
        // Point the current node to the next of next node, skipping one node
        node.next = node.next.next;
    }

    private void printLinkedList(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
