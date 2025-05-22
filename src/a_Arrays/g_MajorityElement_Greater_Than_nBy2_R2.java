package a_Arrays;

public class g_MajorityElement_Greater_Than_nBy2_R2 {

    /*Given an array nums of size n, return the majority element.

    The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.



    Example 1:

    Input: nums = [3,2,3]
    Output: 3
    Example 2:

    Input: nums = [2,2,1,1,1,2,2]
    Output: 2


    Constraints:

    n == nums.length
    1 <= n <= 5 * 104
    -109 <= nums[i] <= 109
    */

    public static void main(String[] args) {
        int arr[] = {2, 2, 1, 1, 1, 2, 2};

        g_MajorityElement_Greater_Than_nBy2_R2 majorityElementGreaterThanNBy2 = new g_MajorityElement_Greater_Than_nBy2_R2();
        int result = majorityElementGreaterThanNBy2.majorityElement(arr);
        if(result==-1){
            System.out.println("No majority element is present");
        }else{
            System.out.println("Majority element = "+result);
        }
    }

    /**
     * This method implements the Boyer-Moore Voting Algorithm to find the majority element in an array.
     * The majority element is the element that appears more than n/2 times in the array.
     *
     * Algorithm:
     * 1. **Candidate Selection (First Pass)**:
     *    - Use a counter to track the frequency of a candidate element.
     *    - If the counter becomes zero, select a new candidate.
     *
     * 2. **Candidate Verification (Second Pass)**:
     *    - Verify if the selected candidate is indeed the majority element by counting its occurrences.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param arr The input array of integers.
     * @return The majority element if it exists, otherwise -1.
     */

    public int majorityElement(int arr[]) {

        int cnt = 0; // Counter to track the frequency of the current candidate
        int element = arr[0]; // Initialize the first element as the candidate

        // First pass: Identify a potential majority element
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                cnt++; // Increment count if current element matches the candidate
            } else {
                cnt--; // Decrement count otherwise
            }
            if (cnt <= 0) { // Reset candidate if count becomes zero
                element = arr[i];
                cnt = 1;
            }
        }

        // Second pass: Verify if the candidate is the majority element
        if (cnt > 0) {
            cnt = 0; // Reset count for verification
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == element) {
                    cnt++; // Count occurrences of the candidate
                }
            }
            return element; // Return the majority element
        }

        return -1; // Return -1 if no majority element is found
    }
}
