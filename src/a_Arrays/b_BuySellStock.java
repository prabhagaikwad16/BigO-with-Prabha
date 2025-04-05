package a_Arrays;

public class b_BuySellStock {
    public static void main(String[] args) {
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};

        b_BuySellStock buySellStock = new b_BuySellStock();
        int profit = buySellStock.maxProfit(arr);
        System.out.printf("Max profit = "+profit);
    }

    public int maxProfit(int[] arr) {

        int min = arr[0];        // Minimum price seen so far (best day to buy)
        int profit = 0;          // Max profit seen so far
        int currentProfit = 0;   // Profit if we sell today

        for (int i = 0; i < arr.length; i++) {

            currentProfit = arr[i] - min; // Profit if bought at min and sold today

            if (profit < currentProfit) {
                profit = currentProfit;   // Update max profit if today's is better
            }

            if (min > arr[i]) {
                min = arr[i];             // Update min if today's price is lower
            }
        }

        return profit;
    }
    /*Recap-->
    * min--> keeps track of lowest price so far.
    profit--> is updated if selling today gives more gain.*/

}
