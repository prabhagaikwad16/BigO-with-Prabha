package a_Arrays;

/*Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.



Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]


Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class p_Top_K_Frequent_Element_R1 {

    public static void main(String[] args) {
        p_Top_K_Frequent_Element_R1 topKFrequentElement = new p_Top_K_Frequent_Element_R1();
        int result[] = topKFrequentElement.topKFrequent(new int[]{10, 20, 30, 40, 50}, 3);
        for(int i: result){
            System.out.print(i+" ");
        }
    }

    public int[] topKFrequent(int[] nums, int k) {

        //Use HashMap to find out the count of each element's occurrence.
        Map<Integer,Integer> map = new HashMap<>();
        for(int i: nums){
            if(map.containsKey(i)){
                int count = map.get(i);
                map.put(i,count+1);
            }
            else{
                map.put(i,1);
            }
        }
        //Use PriorityQueue to keep track of the top k frequent elements.
        //IMP Note--> Pass comparator to the PriorityQueue to sort the elements based on their frequency.
        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue(Map.Entry.<Integer, Integer>comparingByValue());

        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            minHeap.add(entry);
            if(minHeap.size()>k){
                //Remove element from PriorityQueue if size exceeds k.
                minHeap.poll();
            }
        }

        int result[] = new int[k];
        int i =0;
        for(Map.Entry<Integer,Integer> entry: minHeap){
            result[i++] = entry.getKey();
        }

        return result;

    }
}
