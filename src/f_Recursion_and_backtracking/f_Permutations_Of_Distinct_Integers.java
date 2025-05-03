package f_Recursion_and_backtracking;

import java.util.ArrayList;
import java.util.List;

public class f_Permutations_Of_Distinct_Integers {

    public static void main(String[] args) {

        int arr[] = {1,2,3};
        f_Permutations_Of_Distinct_Integers permutationsOfDistinctIntegers = new f_Permutations_Of_Distinct_Integers();
        List<List<Integer>> result = permutationsOfDistinctIntegers.permute(arr);

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findPermutation(0, nums, result);
        return result;
    }

    private void findPermutation(int index, int arr[], List<List<Integer>> result){

        if(index == arr.length){
            List<Integer> subset = new ArrayList<>();
            for(int i=0; i<arr.length;i++){
                subset.add(arr[i]);
            }
            System.out.println(subset);
            result.add(subset);
            return;
        }

        for(int i=index; i<arr.length;i++){
            swap(i,index,arr);
            findPermutation(index+1,arr,result);
            swap(i,index,arr);
        }
    }

    private void swap(int i, int j, int arr[]){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
