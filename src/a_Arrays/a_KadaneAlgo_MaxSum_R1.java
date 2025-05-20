package a_Arrays;

/*Given an integer array nums, find the subarray with the largest sum, and return its sum.

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.


Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
 */

//Observation--> The approach is same like finding element in an array which is greater than n/2

public class a_KadaneAlgo_MaxSum_R1 {

    public static void main(String[] args) {
        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        a_KadaneAlgo_MaxSum_R1 aKadaneAlgoMaxSum = new a_KadaneAlgo_MaxSum_R1();
        int maxSum = aKadaneAlgoMaxSum.maxSubArray(arr);
        System.out.printf("max sum = " + maxSum);
    }

    /**
     * Kadane's Algorithm:
     * Finds the maximum sum of any contiguous subarray.
     * Time Complexity: O(n)
     */
    public int maxSubArray(int[] arr) {

        int maxSum = Integer.MIN_VALUE; // Stores the maximum subarray sum found so far
        int sum = 0; // Stores the current subarray sum

        for (int i = 0; i < arr.length; i++) {

            sum = sum + arr[i]; // Add current element to running-sum

            // Update maxSum if current running sum is greater
            if (maxSum < sum) {
                maxSum = sum;
            }

            // If running sum becomes negative, reset it to 0
            // (as negative sum will reduce future total)
            if (sum < 0) {
                sum = 0;
            }
        }

        return maxSum;
    }
}

/*Recap-->
* sum → running total (reset if negative).
maxSum → tracks highest sum seen so far.*/

