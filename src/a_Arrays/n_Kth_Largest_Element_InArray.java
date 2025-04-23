package a_Arrays;

import java.util.PriorityQueue;

public class n_Kth_Largest_Element_InArray {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int k = 2;
        n_Kth_Largest_Element_InArray kthLargestElementInArray = new n_Kth_Largest_Element_InArray();
        int result = kthLargestElementInArray.kthLargestElement(arr, k);
        System.out.println("The " + k + "th largest element is: " + result);
    }

    public int kthLargestElement(int[] arr, int k) {

        if(arr == null || arr.length ==0 || k<=0 || k>arr.length){
            return -1; //Invalid case
        }

        //Taking priority queue to save the elements because after adding the element it automatically sorts it.
        PriorityQueue<Integer> minHeap = new PriorityQueue();//by default minimum element is stored at the top.

        for(int i=0; i< arr.length; i++){

            minHeap.add(arr[i]);

            if(minHeap.size()>k){
                //poll() function removes top element
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}
