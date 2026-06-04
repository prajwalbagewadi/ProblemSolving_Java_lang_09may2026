//Question: https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/

/* 
1351. Count Negative Numbers in a Sorted Matrix
Solved

Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.

Example 1:
Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8
Explanation: There are 8 negatives number in the matrix.

Example 2:
Input: grid = [[3,2],[1,0]]
Output: 0
 
Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 100
-100 <= grid[i][j] <= 100
 
Follow up: Could you find an O(n + m) solution?
*/

/*
Steps:
1. Start.
2. Take input 2D array int[][] grid.
3. Create new var of type int cnt=0 and c=grid[0].length.
4. For int i=0 to i<grid.length*c; (increament i++).
5. Check if grid[i/c(row)][i%c(col)] < 0.
6. Increament cnt++.
7. Return cnt.
8. Stop.
*/

class Solution {
    public int countNegatives(int[][] grid) {
       int cnt=0,c=grid[0].length;    
       for(int i=0; i<grid.length*c; i++) {
           if(grid[i/c][i%c]<0) {
               cnt++;
           }
       }
       return cnt;
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
        int[][] grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        Solution s = new Solution();
        System.out.println(s.countNegatives(grid));
    }
}

/*
Time Complexity:
1 loop.
Visits every element once so row * col
O(n*m).
*/

/*
Output:

Start small. Ship something.
8

=== Code Execution Successful ===
*/
