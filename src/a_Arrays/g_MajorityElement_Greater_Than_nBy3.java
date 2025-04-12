package a_Arrays;

import java.util.ArrayList;
import java.util.List;

public class g_MajorityElement_Greater_Than_nBy3 {

    public static void main(String[] args) {
        int arr[] = {3,2,3};
        g_MajorityElement_Greater_Than_nBy3 majorityElementGreaterThanNBy3 = new g_MajorityElement_Greater_Than_nBy3();
        List<Integer> result = majorityElementGreaterThanNBy3.majorityElement(arr);
        for (int i=0;i<result.size();i++){
            System.out.print(result.get(i)+" ");
        }
    }

    public List<Integer> majorityElement(int[] arr) {

        int cnt1 = 0;
        int cnt2 = 0;
        int element1 = -1;
        int element2 = -1;

        List<Integer> result = new ArrayList<>();

        // First pass: Identify potential candidates
        for (int i = 0; i < arr.length; i++) {
            // If count1 is 0, assign the current element to element1 (but ensure it's not element2)
            if (cnt1 == 0 && arr[i] != element2) {
                element1 = arr[i];
                cnt1 = 1;
            }
            // If count2 is 0, assign the current element to element2 (but ensure it's not element1)
            else if (cnt2 == 0 && arr[i] != element1) {
                element2 = arr[i];
                cnt2 = 1;
            }
            // Increment count1 if the current element matches element1
            else if (arr[i] == element1) {
                cnt1++;
            }
            // Increment count2 if the current element matches element2
            else if (arr[i] == element2) {
                cnt2++;
            }
            // Decrement both counts if the current element matches neither
            else {
                cnt1--;
                cnt2--;
            }
        }

        // Reset counts for verification
        cnt1 = 0;
        cnt2 = 0;

        // Second pass: Verify the candidates
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element1) {
                cnt1++;
            } else if (arr[i] == element2) {
                cnt2++;
            }
        }

        // Add valid candidates to the result
        // Remember: At most, only 2 elements can appear more than n/3 times
        if (cnt1 > arr.length / 3) {
            result.add(element1);
        }
        if (cnt2 > arr.length / 3) {
            result.add(element2);
        }

        return result;
    }
}
