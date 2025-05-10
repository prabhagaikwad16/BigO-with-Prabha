package g_greedy;

public class c_JumpGame_1 {

    public static void main(String[] args) {
        int arr[] = {3,2,1,0,4};

        c_JumpGame_1 jumpGame = new c_JumpGame_1();
        boolean result = jumpGame.canJump(arr);
        System.out.println("Result = "+result);
    }


    public boolean canJump(int[] arr) {
        int goal = arr.length-1;

        for(int i=arr.length-2; i>=0; i--){
            if(i+arr[i]>=goal){
                goal = i;
            }
        }

        return goal == 0;
    }
}
