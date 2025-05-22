package a_Arrays;

public class m_CountMaxConsecutiveOnes_R2 {
    public static void main(String[] args) {

        int arr[] = {1,0,1,1,0,1};

        m_CountMaxConsecutiveOnes_R2 maxConsecutiveOnes = new m_CountMaxConsecutiveOnes_R2();
        int max = maxConsecutiveOnes.findMaxConsecutiveOnes(arr);
        System.out.println("Max = "+max);
    }


    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;

        for (int num : nums) {
            if (num == 1) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }

        return max;
    }

}
