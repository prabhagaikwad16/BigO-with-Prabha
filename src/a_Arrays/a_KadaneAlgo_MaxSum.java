package a_Arrays;

public class a_KadaneAlgo_MaxSum {

    public static void main(String[] args) {
        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        a_KadaneAlgo_MaxSum aKadaneAlgoMaxSum = new a_KadaneAlgo_MaxSum();
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

            sum = sum + arr[i]; // Add current element to running sum

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

