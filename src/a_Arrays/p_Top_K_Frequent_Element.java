package a_Arrays;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;

public class p_Top_K_Frequent_Element {

    public static void main(String[] args) {
        p_Top_K_Frequent_Element topKFrequentElement = new p_Top_K_Frequent_Element();
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


        //IMP--> Revise implementation of Comparator.
        PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue(new Comparator<Map.Entry<Integer,Integer>>(){
            public int compare(Map.Entry<Integer,Integer> a, Map.Entry<Integer, Integer> b){
                return a.getValue().compareTo(b.getValue());
            }
        });

        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            minHeap.add(entry);
            if(minHeap.size()>k){
                //Remove element from PriorityQueue if size exceeds k.
                Map.Entry<Integer,Integer> element = minHeap.poll();
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
