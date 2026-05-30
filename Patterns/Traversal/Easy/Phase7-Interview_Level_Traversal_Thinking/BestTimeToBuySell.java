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

/*
Steps:
1. Start.
2. Take input array int[] prices.
3. Create a new int buy and set it to buy = prices[0].
4. Create a new int p(profit) and set it to p = 0.
5. For int s(sell)=1 to s<prices.length (increament s++).
6. Check if prices[s]<buy.
7. Set buy = prices[s].
8. Check if prices[s]-buy > p.
9. Set p = prices[s]-buy.
10. Return p.
11. Stop.
*/

class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int p = 0;
        for(int s=1; s<prices.length; s++) {
            if(prices[s]<buy) {
                buy = prices[s];
            }
            if(prices[s]-buy>p) {
                p = prices[s]-buy;
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
Time Complexity:
loop 1 -> check if current<buy and current>profit return profit
O(n)
*/


/*
Test case failed:
[2,1,2,1,0,1,2]
Expected
2

Output:
Start small. Ship something.
2

=== Code Execution Successful ===
=== Testcase passed ===
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