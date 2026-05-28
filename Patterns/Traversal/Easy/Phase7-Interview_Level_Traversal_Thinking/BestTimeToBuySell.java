//Question: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
/*
121. Best Time to Buy and Sell Stock

You are given an array prices where prices[i] is the price of a given stock on the ith day.

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

class Solution {
    public int maxProfit(int[] prices) {
        int b=0;
        int p=0;
        for(int s=1; s<prices.length; s++) {
            if(prices[s]-prices[b]<0 || prices[s]<prices[b]) {
                b++;
            }
            else {
                if(prices[s]-prices[b]>p) {
                    p = prices[s]-prices[b];
                }
            }
        }
        return p;
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
        //int[] stock = {7,1,5,3,6,4};
        int[] stock = {2,1,2,1,0,1,2};
        Solution s = new Solution();
        System.out.println(s.maxProfit(stock));
    }
    
}


/*
Test case failed:
[2,1,2,1,0,1,2]
Expected
2
*/

/*
Output:
Start small. Ship something.
5

=== Code Execution Successful ===

Start small. Ship something.
1

=== Code Execution Successful ===
*/


/*
Notes:
{7,1,5,3,6,4}
profit = sell - Buy

- So:
Buy at 7.
Sell at 1.
- Gives:
1-7 = -6
Which is loss

- Increament Buy counter.

- So:
Buy at 1.
Sell at 5.
- Gives:
5-1 = 4
Which is profit of 4.
*/
