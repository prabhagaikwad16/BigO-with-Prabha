package a_Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class i_2Sum {
    public static void main(String[] args) {
        int arr[]= {2,7,11,15};
        int target=20;
        i_2Sum twoSum = new i_2Sum();
        boolean isPresent = twoSum.twoSumPresent(arr, target);
        System.out.println("Is pair present = "+isPresent);
        int[] result = twoSum.twoSum(arr, target);
        if(result.length!=0){
            System.out.println("Pair is:  "+result[0]+" and "+result[1]);
        }
    }

    /* Approach 1 --> When indices are expected */
    public int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>(arr.length); // Map to store array values and their indices
        int result[];

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(target - arr[i])) { // Check if the complement exists in the map
                result = new int[2];
                result[0] = map.get(target - arr[i]); // Index of the complement
                result[1] = i; // Current index
                return result;
            }
            map.put(arr[i], i); // Add current element and its index to the map
        }
        return new int[0]; // Return empty array if no pair is found
    }

/* Time Complexity: O(n) - Single pass through the array
   Space Complexity: O(n) - For the HashMap
   When to prefer: Use this approach when you need the indices of the pair. */

    /* Approach 2 --> When just have to return if pair is present */
    public boolean twoSumPresent(int[] arr, int target) {
        Arrays.sort(arr); // Sort the array
        int left = 0; // Pointer to the start of the array
        int right = arr.length - 1; // Pointer to the end of the array

        while (left < right) {
            if (arr[left] + arr[right] == target) { // Check if the sum matches the target
                return true; // Pair found
            } else if (arr[left] + arr[right] > target) {
                right--; // Decrease the right pointer if sum is too large
            } else {
                left++; // Increase the left pointer if sum is too small
            }
        }
        return false; // Return false if no pair is found
    }

/* Time Complexity: O(n log n) - Due to sorting
   Space Complexity: O(1) - No extra space used apart from variables
   When to prefer: Use this approach when you only need to check if a pair exists and do not need the indices. */
}
