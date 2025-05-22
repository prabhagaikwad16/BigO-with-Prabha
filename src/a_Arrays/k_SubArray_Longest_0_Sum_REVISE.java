package a_Arrays;

import java.util.HashMap;
import java.util.Map;

/*Given an array arr containing both positive and negative integers, the task is to compute the length of the largest subarray that has a sum of 0.

Examples:

Input: arr[] = [15, -2, 2, -8, 1, 7, 10, 23]
Output: 5
Explanation: The largest subarray with a sum of 0 is [-2, 2, -8, 1, 7].
Input: arr[] = [2, 10, 4]
Output: 0
Explanation: There is no subarray with a sum of 0.
Input: arr[] = [1, 0, -4, 3, 1, 0]
Output: 5
Explanation: The subarray is [0, -4, 3, 1, 0].
Constraints:
1 ≤ arr.size() ≤ 106
−103 ≤ arr[i] ≤ 103, for each valid i*/

public class k_SubArray_Longest_0_Sum_REVISE {

    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 3};

        k_SubArray_Longest_0_Sum_REVISE solver = new k_SubArray_Longest_0_Sum_REVISE();
        int maxSubArrayLength = solver.longestZeroSumSubarray(arr);
        System.out.println("Longest subarray with sum 0 length: " + maxSubArrayLength);
    }

    /*If a prefix sum is repeated, the subarray between the two indices has zero sum*/

    public int longestZeroSumSubarray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        Map<Integer, Integer> sumIndexMap = new HashMap<>();
        int maxLength = 0;
        int cumulativeSum = 0;

        for (int i = 0; i < arr.length; i++) {
            cumulativeSum += arr[i];

            // Case 1: subarray from start has sum 0
            if (cumulativeSum == 0) {
                maxLength = i + 1;
            }

            // Case 2: repeated cumulative sum — sum between those indices is 0
            if (sumIndexMap.containsKey(cumulativeSum)) {
                int prevIndex = sumIndexMap.get(cumulativeSum);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                // Store only the first occurrence of this cumulative sum
                sumIndexMap.put(cumulativeSum, i);
            }
        }

        return maxLength;
    }
}
