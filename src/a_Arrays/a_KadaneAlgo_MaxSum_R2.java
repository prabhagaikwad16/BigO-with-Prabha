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

public class a_KadaneAlgo_MaxSum_R2 {

    public static void main(String[] args) {
        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        a_KadaneAlgo_MaxSum_R2 aKadaneAlgoMaxSum = new a_KadaneAlgo_MaxSum_R2();
        int maxSum = aKadaneAlgoMaxSum.maxSubArray(arr);
        System.out.printf("max sum = " + maxSum);
    }


    // 🔑 Kadane's Algorithm: Track current sum, reset if it drops below 0.
    // Max sum is updated whenever current sum exceeds previous max.
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int num : nums) {
            currentSum += num;
            maxSum = Math.max(maxSum, currentSum);

            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }

}

/*Recap-->
* sum → running total (reset if negative).
maxSum → tracks highest sum seen so far.*/

