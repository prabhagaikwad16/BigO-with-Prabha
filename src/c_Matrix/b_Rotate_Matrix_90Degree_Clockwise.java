package c_Matrix;

public class b_Rotate_Matrix_90Degree_Clockwise {
    public static void main(String[] args) {
        int arr[][] = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        b_Rotate_Matrix_90Degree_Clockwise rotateMatrix90DegreeClockwise = new b_Rotate_Matrix_90Degree_Clockwise();
        System.out.println("Before rotating: ");
        rotateMatrix90DegreeClockwise.printMatrix(arr);
        rotateMatrix90DegreeClockwise.rotate(arr);
        System.out.println("After rotating: ");
        rotateMatrix90DegreeClockwise.printMatrix(arr);
    }

    public void rotate(int[][] arr) {

        // Step 1: Transpose the matrix (convert rows to columns)
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        // Step 2: Reverse each row (for clockwise rotation)
        for (int i = 0; i < arr.length; i++) {
            int left = 0, right = arr[0].length - 1;
            while (left < right) {
                int temp = arr[i][left];
                arr[i][left] = arr[i][right];
                arr[i][right] = temp;
                left++;
                right--;
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
