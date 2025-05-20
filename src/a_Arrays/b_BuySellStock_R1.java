package a_Arrays;

/*You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.



Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.


Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104
*/

public class b_BuySellStock_R1 {
    public static void main(String[] args) {
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};

        b_BuySellStock_R1 buySellStock = new b_BuySellStock_R1();
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
