package e_Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class b_FindNextGreaterElement_In_Different_Arrays {

    public static void main(String[] args) {
        int arr1[] = {4,1,2};
        int arr2[] = {1,3,4,2};

        b_FindNextGreaterElement_In_Different_Arrays findNextGreaterElementInDifferentArrays = new b_FindNextGreaterElement_In_Different_Arrays();
        int result[] = findNextGreaterElementInDifferentArrays.nextGreaterElement(arr1,arr2);

        for(int i: result){
            System.out.print(i+" ");
        }
    }

    public int[] nextGreaterElement(int[] arr1, int[] arr2) {

        Map<Integer, Integer> map = new HashMap<>(); // To store next greater element for each number in arr2
        Stack<Integer> stack = new Stack<>(); // Helps to find next greater element quickly

        // Go through arr2 from end to start to find "next greater" on the right
        for(int i = arr2.length - 1; i >= 0; i--) {

            // Remove smaller numbers from stack since they can't be "next greater"
            while(!stack.isEmpty() && arr2[i] > stack.peek()) {
                stack.pop();
            }

            // If nothing greater is found, mark it as -1
            if(stack.isEmpty()) {
                map.put(arr2[i], -1);
            } else {
                map.put(arr2[i], stack.peek()); // Top of stack is next greater
            }

            stack.push(arr2[i]); // Current number might be next greater for future elements
        }

        int[] result = new int[arr1.length];

        // Just look up answers for arr1 using the map we built
        for(int i = 0; i < arr1.length; i++) {
            result[i] = map.get(arr1[i]);
        }

        return result;
    }

}
