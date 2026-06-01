//Question: https://leetcode.com/problems/richest-customer-wealth/description/

/*
1672. Richest Customer Wealth

You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the i​​​​​​​​​​​th​​​​ customer has in the j​​​​​​​​​​​th​​​​ bank. Return the wealth that the richest customer has.

A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer that has the maximum wealth.

Example 1:
Input: accounts = [[1,2,3],[3,2,1]]
Output: 6
Explanation:
1st customer has wealth = 1 + 2 + 3 = 6
2nd customer has wealth = 3 + 2 + 1 = 6
Both customers are considered the richest with a wealth of 6 each, so return 6.

Example 2:
Input: accounts = [[1,5],[7,3],[3,5]]
Output: 10
Explanation: 
1st customer has wealth = 6
2nd customer has wealth = 10 
3rd customer has wealth = 8
The 2nd customer is the richest with a wealth of 10.

Example 3:
Input: accounts = [[2,8,7],[7,1,3],[1,9,5]]
Output: 17

Constraints:
m == accounts.length
n == accounts[i].length
1 <= m, n <= 50
1 <= accounts[i][j] <= 100
*/

class Solution {
    public int maximumWealth(int[][] accounts) {
        int max=0,sum=0,c=accounts[0].length;
        for(int i=0; i<accounts.length*accounts[0].length; i++) {
            sum+=accounts[i/c][i%c];
            System.out.println("sum="+sum);
            if(sum>max) {
                max=sum;
                System.out.println("max="+max);
            }
            //interval reset
            if((i+1)%accounts[0].length==0) {
                sum=0;
            }
        }
        return max;
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
        //int[][] w = {{1,2,3},{3,2,1}};
        int[][] w = {{1,5},{7,3},{3,5}};
        Solution s = new Solution();
        System.out.println(s.maximumWealth(w));
    }
}

/*
Notes:
As we Flattened a 2D array.
We need a interval to reset sum at end of each account(Row.length).

Reset (Interval):
- Sum should reset at (End of each Row).
Formula:
if((i + 1) % matrix[0].length == 0) {
//reset procedure.
}
*/

/*
Output:
Start small. Ship something.
10

=== Code Execution Successful ===

Start small. Ship something.
sum=1
max=1
sum=6
max=6
sum=7
max=7
sum=10
max=10
sum=3
sum=8
10

=== Code Execution Successful ===
*/