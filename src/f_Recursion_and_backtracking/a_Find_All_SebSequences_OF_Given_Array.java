package f_Recursion_and_backtracking;

import java.util.ArrayList;
import java.util.List;

public class a_Find_All_SebSequences_OF_Given_Array {

    public static void main(String[] args) {
        int arr[] = {3,1,2};

        a_Find_All_SebSequences_OF_Given_Array findAllSebSequencesOfGivenArray = new a_Find_All_SebSequences_OF_Given_Array();
        List<List<Integer>> result = findAllSebSequencesOfGivenArray.findSequences(arr);
        System.out.println("All subsequences of the given array are: ");
        for(List<Integer> subSequence : result){
            System.out.println(subSequence);
        }
    }

    public List<List<Integer>> findSequences(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        findAllSubSequences(0, arr, new ArrayList<>(), result);
        return result;
    }

    /*
     * Definition:
     * A subsequence is a sequence that can be derived from an array
     * by deleting zero or more elements without changing the order
     * of the remaining elements.
     *
     * Example:
     * Array: [3, 1, 2]
     * Subsequences: [], [3], [1], [2], [3,1], [3,2], [1,2], [3,1,2]
     */

    private void findAllSubSequences(int index, int[] arr, List<Integer> subsequence, List<List<Integer>> result) {
        // Base case: if we have considered all elements
        if (index == arr.length) {
            // IMPORTANT:
            // We must add a NEW copy of subsequence,
            // because 'subsequence' is a single object that changes throughout recursion.
            // If we add 'subsequence' directly, all entries in 'result' will point to the SAME object and get modified.
            result.add(new ArrayList<>(subsequence));
            return;
        }

        // Recursive case:

        // 1. Pick the current element
        subsequence.add(arr[index]); // Choose the element
        findAllSubSequences(index + 1, arr, subsequence, result); // Explore further with element picked

        // 2. Don't pick the current element
        subsequence.remove(subsequence.size() - 1); // Undo the choice (Backtrack)
        findAllSubSequences(index + 1, arr, subsequence, result); // Explore further without picking
    }

}
