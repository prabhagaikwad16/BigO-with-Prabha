package c_Matrix;

public class c_Rotate_Matrix_90Degree_Anti_Clockwise {
    public static void main(String[] args) {
        int arr[][] = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        c_Rotate_Matrix_90Degree_Anti_Clockwise rotateMatrix90DegreeAntiClockwise = new c_Rotate_Matrix_90Degree_Anti_Clockwise();
        System.out.println("Before rotation: ");
        rotateMatrix90DegreeAntiClockwise.printMatrix(arr);

        rotateMatrix90DegreeAntiClockwise.rotate(arr);
        System.out.println("After rotation: ");
        rotateMatrix90DegreeAntiClockwise.printMatrix(arr);

    }

    public void rotate(int[][] arr) {

        // Step 1: Transpose the matrix
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr[0].length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        // Step 2: Reverse each column (for anti-clockwise rotation)
        for (int j = 0; j < arr[0].length; j++) {
            int top = 0, bottom = arr.length - 1;
            while (top < bottom) {
                int temp = arr[top][j];
                arr[top][j] = arr[bottom][j];
                arr[bottom][j] = temp;
                top++;
                bottom--;
            }
        }
    }


    private void printMatrix(int arr[][]){
        for(int i=0; i<arr.length; i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
