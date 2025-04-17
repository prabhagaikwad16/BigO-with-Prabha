package a_Arrays;

import java.util.HashMap;
import java.util.Map;

public class k_SubArray_Longest_0_Sum {

    public static void main(String[] args) {
        int arr[] = {1, 2, -3, 3};

        k_SubArray_Longest_0_Sum subArrayLongest0Sum = new k_SubArray_Longest_0_Sum();
        int maxSubArrayLength = subArrayLongest0Sum.longestZeroSumSubarray(arr);
        System.out.println(maxSubArrayLength);
    }

    public int longestZeroSumSubarray(int[] arr) {


        if(arr == null || arr.length== 0){
            return 0;
        }

        int maxLength = 0;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < arr.length;i++){
            sum = sum + arr[i];

            //as we are keep adding to sum from 0 index then whatever i currently points to will be the max possible length thats why below logic.
            if(sum == 0){
                maxLength = i+1;
            }else{
                //if this condition satisfies for the recently found element then do not add the element to the map because
                // it will replace in index i to the newer index but its better to have older i.e smaller index to calculate maximum length starting from that smaller index previously found.
                if(map.containsKey(sum)){
                    int start = map.get(arr[i]);
                    int currentLength = i-start;
                    if(maxLength<currentLength){
                        maxLength = currentLength;
                    }
                }else{
                    map.put(arr[i],i);
                }
            }
        }

        return maxLength;
    }
}
