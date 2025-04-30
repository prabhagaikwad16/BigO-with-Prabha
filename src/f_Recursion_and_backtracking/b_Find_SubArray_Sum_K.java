package f_Recursion_and_backtracking;

import java.util.ArrayList;
import java.util.List;

public class b_Find_SubArray_Sum_K {

    public static void main(String[] args) {

        int arr[] = {1,1,1};
        int target = 2;
        b_Find_SubArray_Sum_K findSubArraySumK = new b_Find_SubArray_Sum_K();
        int result = findSubArraySumK.subarraySum(arr,target);
        System.out.println("Total subarrays with sum " + target + " = " + result);
    }

    public int subarraySum(int arr[],int expectedSum){
        List<List<Integer>> result = new ArrayList<>();
        findSubArraysWithSumK(0,arr,new ArrayList<>(),0,expectedSum,result);
        for(List list: result){
            System.out.println(list);
        }
        return result.size();
    }

    private void findSubArraysWithSumK(int index, int arr[], List<Integer> subArray,int currentSum, int target, List<List<Integer>> result){

        if(index == arr.length){
            if(currentSum == target){
                result.add(new ArrayList<>(subArray));
            }
            return;
        }


        subArray.add(arr[index]);
        findSubArraysWithSumK(index+1, arr, subArray, currentSum + arr[index], target, result);

        subArray.remove(subArray.size()-1);
        findSubArraysWithSumK(index+1, arr, subArray, currentSum, target, result); //Exclude current element (arr[index])
    }

}
