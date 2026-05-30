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

/*
Steps:
1. Start.
2. Take input array n*m accounts.
3. Create a new int var max and set it to max=0.
4. For int[] c in accounts.
5. Create a new int var sum and set it to sum=0;
6. For int m in c.
7. Set sum = sum + m;
8. Check if sum > max.
9. Set max = sum.
10. Return max.
11. Stop
*/

class Solution {
    public int maximumWealth(int[][] accounts) {
        int max=0;
        
        for(int[] c : accounts) {
            int sum=0;
            for(int m : c) {
                sum = sum + m;
            }
            System.out.println("customer wealth:"+sum);
            if(sum > max) {
                max = sum;
            }
        }
        return max;
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
        Solution s = new Solution();
        //int[][] acc = {{1,2,3},{3,2,1}};
        int[][] acc = {{1,5},{7,3},{3,5}};
        System.out.println("rich customer:"+s.maximumWealth(acc));
    }
}

/*
output:
Start small. Ship something.
customer wealth:6
customer wealth:10
customer wealth:8
rich customer:10
*/

/* 
Time Complexity:
loop 1 -> calculate wealth and check max build the result.
O(n).
*/