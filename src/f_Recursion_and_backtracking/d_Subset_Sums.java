package f_Recursion_and_backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class d_Subset_Sums {

    public static void main(String[] args) {
        int arr[] = {5, 2, 1};

        d_Subset_Sums subsetSums = new d_Subset_Sums();
        List<Integer> result = subsetSums.subsetSums(arr);
        System.out.println("Subset Sums:");
        for(Integer i: result){
            System.out.print(i+" ");
        }
    }

    public List<Integer> subsetSums(int[] arr) {
        List<Integer> result = new ArrayList<>();
        findSubSetSums(0,arr,0,result);
        Collections.sort(result);



        return result;
    }

    public void findSubSetSums(int index, int arr[],int sum, List<Integer> result){

        if(index == arr.length){
            result.add(sum);
            return;
        }

        findSubSetSums(index+1, arr, sum+arr[index], result);

        findSubSetSums(index+1, arr, sum, result);
    }


}
