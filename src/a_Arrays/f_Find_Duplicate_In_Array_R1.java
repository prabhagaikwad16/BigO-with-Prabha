package a_Arrays;

/*Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and using only constant extra space.



Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
Example 3:

Input: nums = [3,3,3,3,3]
Output: 3


Constraints:

1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.*/



public class f_Find_Duplicate_In_Array_R1 {

    public static void main(String[] args) {
        int arr[] = {3,1,3,4,2};

        f_Find_Duplicate_In_Array_R1 findDuplicateInArray = new f_Find_Duplicate_In_Array_R1();
        int duplicate = findDuplicateInArray.findDuplicate(arr);
        System.out.println("Duplicate number is = " + duplicate);
    }

    public int findDuplicate(int arr[]) {
        // Initialize slow and fast pointers
        int slow = arr[0];
        int fast = arr[0];

        // Phase 1: Detect cycle using Floyd's Tortoise and Hare algorithm
        do {
            slow = arr[slow];       // Move slow pointer by 1 step
            fast = arr[arr[fast]]; // Move fast pointer by 2 steps
        } while (slow != fast);    // Loop until pointers meet

        // Phase 2: Find the duplicate (cycle entry point)
        fast = arr[0];             // Reset fast pointer to start
        while (slow != fast) {
            slow = arr[slow];      // Move slow pointer by 1 step
            fast = arr[fast];      // Move fast pointer by 1 step
        }

        return slow;               // Duplicate number found
    }
}