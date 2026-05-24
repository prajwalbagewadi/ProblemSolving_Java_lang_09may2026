//Question: https://leetcode.com/problems/matrix-diagonal-sum/description/

/*
1572. Matrix Diagonal Sum

Given a square matrix mat, return the sum of the matrix diagonals.

Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.

Example 1:
Input: mat = [[1,2,3],
              [4,5,6],
              [7,8,9]]
Output: 25
Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
Notice that element mat[1][1] = 5 is counted only once.

Example 2:
Input: mat = [[1,1,1,1],
              [1,1,1,1],
              [1,1,1,1],
              [1,1,1,1]]
Output: 8

Example 3:
Input: mat = [[5]]
Output: 5
 
Constraints:
n == mat.length == mat[i].length
1 <= n <= 100
*/

/*
Steps:
1. Start.
2. Take input 2d array int[][] mat.
3. Create new var of type int sum and set it to sum=0. and Create new var of type int c and set it to mat.length-1.
4. For int i=0 to mat.length (increament i++).
5. Set sum += mat[i][i].
6. For int i=0 to mat.length (increament i++).
7. Check if C!=i.
8. Set sum += mat[i][c].
9. Decreament c--.
10. Return sum.
11. Stop.
*/

class Solution {
    public int diagonalSum(int[][] mat) {
        int sum=0,c=mat.length-1;
        for(int i=0; i<mat.length; i++) {
            sum+=mat[i][i]; 
        }
        //System.out.println(sum);
        for(int i=0; i<mat.length; i++) {
            if(c!=i) {
                sum+=mat[i][c];
            }
            //System.out.println("c="+c);
            c--;
        }
        //System.out.println(sum);
        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        //int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] mat = {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
        Solution s = new Solution();
        System.out.println(s.diagonalSum(mat));
    }
}

/* 
Time complexity:
loop 1 -> runs till mat.length to calculate primary diagonal.
loop 2 -> runs till mat.length to calculate secondary diagonal.
O(n+n) -> O(2n) -> in big O ignore constantants so O(n).
*/

/*
notes:
Primary diagonal mat[row][row] row = col.
Secondary diagonal mat[row][col] row = 0 to n and col = n to 0. -> Run col in Reverse.
*/

/*
output:
15
c=2
c=1
c=0
25
25

=== Code Execution Successful ===

4
c=3
c=2
c=1
c=0
8
8

=== Code Execution Successful ===
*/