package a_Arrays;

public class q_SingleElement_In_Sorted_Array {
    public static void main(String[] args) {

        q_SingleElement_In_Sorted_Array singleElementInSortedArray = new q_SingleElement_In_Sorted_Array();
        int arr[] = {3,3,7,7,10,11,11};
        int result = singleElementInSortedArray.singleNonDuplicate(arr);
        System.out.println("Result = "+result);
    }

    /*Logic is, duplicate pair will always be exists on even and odd number.
    * if first half does not follow it then unique element present in first half else 2nd half.*/
    public int singleNonDuplicate(int[] arr) {
        if(arr == null || arr.length == 0){
            return -1;
        }
        if(arr.length == 1){
            return arr[0];
        }

        int low = 0;
        int high = arr.length-1;
        while(low<high){
            int mid = (low+high)/2;
            if(mid%2 == 1)mid--; // Because we want to compare elements at even and odd position (from start)

            if(arr[mid] == arr[mid+1]){
                low = mid+2;
            }else{
                high = mid;
            }
        }

        return arr[low];
    }
}
