package e_Stack;

import java.util.Stack;

public class a_FindNextGreaterElement_In_Same_Array {

    public static void main(String[] args) {
        int arr[] = {1,3,4,2};

        a_FindNextGreaterElement_In_Same_Array findNextGreaterElementInSameArray = new a_FindNextGreaterElement_In_Same_Array();
        int result[] = findNextGreaterElementInSameArray.nextGreaterElement(arr);

        for(int i:result){
            System.out.print(i+" ");
        }
    }

    //nums2 = [1,3,4,2]
    public int[] nextGreaterElement(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        int result[] = new int[arr.length];

        for(int i = arr.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && arr[i]>stack.peek()){
                stack.pop();
            }
            int peek = -1;
            if(!stack.isEmpty()){
                peek = stack.peek();
            }
            result[i] = peek;
            stack.push(arr[i]);
        }

        return result;
    }
}
