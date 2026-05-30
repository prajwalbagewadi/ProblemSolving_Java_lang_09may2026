//Question: https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/

/*
1351. Count Negative Numbers in a Sorted Matrix

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
2. Take input 2d array int[][] grid.
3. Create a new var of type int count and set it to count=0.
4. For int r=0 to r<grid.length (increament r++)
5. For int c=0 to c<grid[r].length (increament c++)
6. Check if grid[r][c]<0.
7. Increament count++.
8. Return count.
*/

class Solution {
    public int countNegatives(int[][] grid) {
        int count=0;
        for(int r=0; r<grid.length; r++) {
            for(int c=0; c<grid[r].length; c++) {
                if(grid[r][c]<0) {
                    count++;
                }
            }
        }
        return count;
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("hello world.");
        Solution s = new Solution();
        int[][] grid = {{4,3,2,-1},
                        {3,2,1,-1},
                        {1,1,-1,-2},
                        {-1,-1,-2,-3}};

        System.out.println(s.countNegatives(grid));                
    }
}

/*
Time Complexity:
Nested loop -> count and build result.
O(n*m).
*/

/* 
Output:
hello world.
8

=== Code Execution Successful ===
*/
