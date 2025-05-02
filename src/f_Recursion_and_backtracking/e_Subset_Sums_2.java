package f_Recursion_and_backtracking;

import java.lang.reflect.Array;
import java.util.*;

public class e_Subset_Sums_2 {

    public static void main(String[] args) {
        e_Subset_Sums_2 subsetSums2 = new e_Subset_Sums_2();

        int arr[] = {2,5,2,1,2};
        int target = 5;
        List<List<Integer>> result = subsetSums2.combinationSum2(arr,5);
        System.out.println("Subsets with Duplicates:");
        for(List list: result){
            System.out.println(list);
        }
    }

    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>> results = new ArrayList<>();
        //Make sure that array is sorted so that duplicate subset checking works as per the below logic.
        Arrays.sort(arr);
        subsets(0,arr,target,new ArrayList<>(),results);

        return results;
    }


    public void subsets(int index, int arr[],int target, List<Integer> subsets, List<List<Integer>> results){

        if(target == 0){
            //This line make sure that very first empty subset is also considered. And also each and every generated combination of subsets is considered.
            results.add(new ArrayList<>(subsets));
            return;
        }

        //This line does not let go index out of bounds.
        if(index == arr.length){
            return;
        }

        //note--> next for loop starts at the index and not with 0
        for(int i=index; i<arr.length; i++){

            //If next element due to for loop is progressing is same as the already added element then skip it to avoid duplicate subset.
            if(i>index && arr[i] == arr[i-1]){
                continue;
            }

            //No need to run for loop when current element is greater than target as array is sorted already so there is no chance of getting smaller element further.
            if (arr[i] > target) {
                break; // No point in continuing as the array is sorted
            }

            //As the current element for the current index is new, consider it for the subset.
            subsets.add(arr[i]);
            target  = target - arr[i];
            subsets(i+1,arr, target, subsets,results);

            //Remove the previously added element to generate new subset.
            int removed = subsets.remove(subsets.size() - 1);
            target = target + removed;
        }
    }
}
