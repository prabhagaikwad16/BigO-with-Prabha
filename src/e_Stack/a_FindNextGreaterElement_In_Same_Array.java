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

        /*We use a stack to remember the numbers we've already seen while going from right to left.
        It helps us quickly check what number might be the next bigger number for the current element.*/
        Stack<Integer> stack = new Stack<>();
        int result[] = new int[arr.length];

        /*So if you're looking for what's on the right, then naturally you need to start checking from the end — because that’s where the rightmost elements are.
        This way, for each number, you're looking at the things that come after it, not before it.*/
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
