package c_Matrix;

public class a_SetMatrix0_If_Col0_Row0 {
    public static void main(String[] args) {

        int arr[][] = {
                {0}
            };

        a_SetMatrix0_If_Col0_Row0 setMatrix0IfCol0Row0 = new a_SetMatrix0_If_Col0_Row0();
        System.out.println("Matrix before:");
        setMatrix0IfCol0Row0.printMatrix(arr);

        setMatrix0IfCol0Row0.setZeroes(arr);

        System.out.println("Matrix after:");
        setMatrix0IfCol0Row0.printMatrix(arr);

    }

    public void setZeroes(int[][] arr) {

        boolean doesRowHasZero = false; // To track if the first row needs to be zeroed
        boolean doesColHasZero = false; // To track if the first column needs to be zeroed

        // Step 1: Check if the first row has any zero
        for(int i = 0; i < arr[0].length; i++){
            if(arr[0][i] == 0){
                doesRowHasZero = true;
                break;
            }
        }

        // Step 2: Check if the first column has any zero
        for(int j = 0; j < arr.length; j++){
            if(arr[j][0] == 0){
                doesColHasZero = true;
                break;
            }
        }

        // Step 3: Use first row and column as markers to indicate which rows and columns need to be zeroed
        for(int i = 1; i < arr.length; i++){
            for(int j = 1; j < arr[0].length; j++){
                if(arr[i][j] == 0){
                    arr[i][0] = 0; // mark the row
                    arr[0][j] = 0; // mark the column
                }
            }
        }

        // Step 4: Zero out cells based on markers in the first row and column
        for(int i = 1; i < arr.length; i++){
            for(int j = 1; j < arr[0].length; j++){
                if(arr[0][j] == 0 || arr[i][0] == 0){
                    arr[i][j] = 0;
                }
            }
        }

        // Step 5: Finally, zero out the first row if needed
        if(doesRowHasZero){
            for(int j = 0; j < arr[0].length; j++){
                arr[0][j] = 0;
            }
        }

        // Step 6: Finally, zero out the first column if needed
        if(doesColHasZero){
            for(int i = 0; i < arr.length; i++){
                arr[i][0] = 0;
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
