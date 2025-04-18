package a_Arrays;

public class m_CountMaxConsecutiveOnes {
    public static void main(String[] args) {

        int arr[] = {1,0,1,1,0,1};

        m_CountMaxConsecutiveOnes maxConsecutiveOnes = new m_CountMaxConsecutiveOnes();
        int max = maxConsecutiveOnes.findMaxConsecutiveOnes(arr);
        System.out.println("Max = "+max);
    }


    public int findMaxConsecutiveOnes(int[] arr) {
        int max = 0;
        int count = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 1) {
                count++;
                if(max<count){
                    max = count;
                }
            }
            else{count = 0;}
        };

        return max;
    }
}
