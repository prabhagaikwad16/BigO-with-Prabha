package f_Recursion_and_backtracking;

import java.util.ArrayList;
import java.util.List;

public class c_CombinationSum_Repeated_Element {

    public static void main(String[] args) {

        int arr[] = {2,3,6,7};
        int target = 7;
        c_CombinationSum_Repeated_Element combinationSumRepeatedElement = new c_CombinationSum_Repeated_Element();
        List<List<Integer>> result = combinationSumRepeatedElement.combinationSum(arr,target);
        for (List list: result){
            System.out.println(list);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(0,candidates,target,new ArrayList<>(),result);
        return result;
    }

    private void findCombinations(int index, int arr[], int target, List<Integer> combination, List<List<Integer>> result){

        if(index >= arr.length){
            if(target == 0){
                result.add(new ArrayList<>(combination));
            }
            return;
        }
        int newTarget=target;
        if(arr[index]<=target){
            //pick element--> so reduce the target and index will remain the same as we are considering the same element.
            newTarget = newTarget - arr[index];
            combination.add(arr[index]);
            findCombinations(index,arr,newTarget,combination,result);
            //as we have picked the element for the next recursion call we need to remove it for not-to-pick case.
            newTarget = newTarget + arr[index];
            //also make sure you remove it from the combination list.
            combination.remove(combination.size()-1);
        }
        //increase the index for no-pick-call to move to the next index.
        findCombinations(index+1,arr,newTarget,combination,result);
    }
}
