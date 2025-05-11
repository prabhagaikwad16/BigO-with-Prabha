package g_Greedy;

public class d_JumpGame_2 {
    public static void main(String[] args) {

        int arr[] = {2,3,1,1,4};

        d_JumpGame_2 jumpGame2 = new d_JumpGame_2();
        int jumps = jumpGame2.jump(arr);
        System.out.println("Result = "+jumps);
    }

    public int jump(int[] arr) {

        int max = 0;
        int l = 0;
        int r = 0;
        int jump = 0;

        while(r<arr.length-1){

            /* Traverse the range and find out max possible right side of the range.*/
            for(int i=l; i<=r; i++){
                max = Math.max(i+arr[i],max);
            }

            /*Shift left just next to the current right.*/
            l = r+1;
            /*Set right to the latest max to define the range.*/
            r = max;

            /*As there is no zero present in the array at least 1 jump will be there from above for loop*/
            jump++;
        }

        return jump;
    }
}
