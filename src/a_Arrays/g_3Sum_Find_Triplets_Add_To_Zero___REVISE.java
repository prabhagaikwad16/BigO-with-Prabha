package a_Arrays;

import java.util.*;

/*Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.


Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105*/

public class g_3Sum_Find_Triplets_Add_To_Zero___REVISE {
    public static void main(String[] args) {
        int arr[] = {-1,0,1,2,-1,-4};

        g_3Sum_Find_Triplets_Add_To_Zero___REVISE g3SumFindTripletsAddToZero = new g_3Sum_Find_Triplets_Add_To_Zero___REVISE();
        List<List<Integer>> result = g3SumFindTripletsAddToZero.threeSum(arr);
        for(List<Integer> list : result){
            System.out.println(list);
        }
    }

    public List<List<Integer>> threeSum(int[] arr) {
        // Use a Set to store unique triplets and avoid duplicates
        Set<List<Integer>> set = new HashSet<>();

        // Outer loop to fix the first element
        for (int i = 0; i < arr.length; i++) {
            // Map to store the complement (k) and check for pairs
            Map<Integer, Integer> map = new HashMap<>(arr.length);

            // Inner loop to find pairs that sum up to -arr[i]
            for (int j = i + 1; j < arr.length; j++) {
                int k = -(arr[i] + arr[j]); // Calculate the third number (k)

                // If k exists in the map, we found a valid triplet
                if (map.containsKey(k)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(arr[i]);
                    list.add(arr[j]);
                    list.add(k);
                    Collections.sort(list); // Sort to ensure uniqueness
                    set.add(list); // Add to set to avoid duplicate triplets
                }
                // Add the current number to the map
                map.put(arr[j], i);
            }
        }

        // Convert the set of unique triplets to a list
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> list : set) {
            result.add(list);
        }
        return result;
    }
}
