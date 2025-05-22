package a_Arrays;

import java.util.PriorityQueue;

public class n_Kth_Largest_Element_InArray_R1 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 2;

        int result = findKthLargest(arr, k);
        System.out.println("The " + k + "th largest element is: " + result);
    }


    /*Use a min-heap of size k to keep track of the top k largest elements seen so far.
    Insert elements into the heap.
    When heap size exceeds k, remove the smallest element (heap root).

    After processing all elements, the heap root is the kth largest element.*/
    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k || k <= 0) {
            throw new IllegalArgumentException("Invalid input.");
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove smallest
            }
        }

        return minHeap.peek(); // Top of heap is the kth largest
    }
}
