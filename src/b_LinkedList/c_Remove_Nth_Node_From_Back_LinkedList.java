package b_LinkedList;

/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.



Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
 */
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
