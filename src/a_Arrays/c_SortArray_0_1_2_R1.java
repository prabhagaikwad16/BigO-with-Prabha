package a_Arrays;


/*Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.



Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]


Constraints:

n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.*/

public class c_SortArray_0_1_2_R1 {
    public static void main(String[] args) {
        int arr[] = {2,0,2,1,1,0};
        c_SortArray_0_1_2_R1 sortArray = new c_SortArray_0_1_2_R1();
        sortArray.sortColors(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }


    }
    public void sortColors(int arr[]){

        int count0 = 0; // Count of 0s
        int count1 = 0; // Count of 1s
        int count2 = 0; // Count of 2s

        for(int i =0; i < arr.length; i++){
            if(arr[i] == 0){
                count0++;
            }else if(arr[i] == 1){
                count1++;
            }else{
                count2++;
            }
        }

        // Fill the array with 0s, 1s, and 2s based on their counts
        int j = 0;
        for(int i =0; i < count0; i++){
            arr[j++] = 0;
        }

        for(int i = 0; i < count1; i++){
            arr[j++] = 1;
        }

        for (int i = 0; i < count2; i++){
            arr[j++] = 2;
        }
    }
}
