package b_LinkedList;

import java.util.LinkedList;

public class h_Check_Palindrome_LinkedList {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        h_Check_Palindrome_LinkedList checkPalindromeLinkedList = new h_Check_Palindrome_LinkedList();


        boolean palindrome = checkPalindromeLinkedList.isPalindrome(head);

        System.out.println("palindrome = "+palindrome);
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        if (head.next == null) return true;

        // Find the middle of the list
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // For odd length, skip the middle node
        if (fast != null) slow = slow.next;

        // Reverse second half starting from slow
        ListNode secondHalf = reverseLinkedList(slow);

        // Compare first half and reversed second half
        ListNode firstHalf = head;
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) return false;
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    // In-place reversal of linked list
    private ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    private void printLinkedList(ListNode head){
        while(head!=null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
//1 2 3 2 1

//1 2 2 1