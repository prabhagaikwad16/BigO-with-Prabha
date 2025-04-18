package a_Arrays;

public class l_RemoveDuplicates_SortedArray {

    public static void main(String[] args) {

        int arr[] = {0,0,1,1,1,2,2,3,3,4};
        l_RemoveDuplicates_SortedArray removeDuplicatesSortedArray  = new l_RemoveDuplicates_SortedArray();
        int length = removeDuplicatesSortedArray.removeDuplicates(arr);
        for(int i = 0; i<length; i++){
            System.out.print(i+" ");
        }
    }

    public int removeDuplicates(int[] arr) {
        if (arr.length == 0) return 0;

        int slow = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[slow]) {
                arr[++slow] = arr[i];
            }
        }
        return slow + 1; // returns count of unique elements
    }

}
