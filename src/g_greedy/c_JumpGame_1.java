package g_greedy;

public class c_JumpGame_1 {

    public static void main(String[] args) {
        int arr[] = {3,2,1,0,4};

        c_JumpGame_1 jumpGame = new c_JumpGame_1();
        boolean result = jumpGame.canJump(arr);
        System.out.println("Result = "+result);
    }


    public boolean canJump(int[] arr) {
        int maxLength = 0;
        int max = 0;
        for(int i=0;i< arr.length; i++){

            if(i>maxLength){
                return false;
            }
            else if(maxLength>=arr.length){
                return true;
            }

            //standing at index i and can jump to index arr[i]
            max = i+arr[i];
            maxLength = maxLength<max?max:maxLength;

        }

        return true;
    }
}
