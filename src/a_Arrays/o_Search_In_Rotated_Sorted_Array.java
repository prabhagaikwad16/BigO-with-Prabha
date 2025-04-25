package a_Arrays;

public class o_Search_In_Rotated_Sorted_Array {
    public static void main(String[] args) {
        int arr[] = {1};
        int target = 2;

        o_Search_In_Rotated_Sorted_Array searchInRotatedSortedArray = new o_Search_In_Rotated_Sorted_Array();
        int result = searchInRotatedSortedArray.search(arr,target);
        System.out.println(result);
    }


    public int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (arr[low] <= arr[mid]) {
                if (target >= arr[low] && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (target > arr[mid] && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

}
