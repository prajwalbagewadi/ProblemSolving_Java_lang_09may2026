//Question: https://leetcode.com/problems/spiral-matrix/description/

/*
54. Spiral Matrix

Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]


Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 
Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
*/

import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        List<Integer> out = new ArrayList<>();
        for(int r=0; r<m; r++) {
            out.add(matrix[0][r]);
        }
        for(int c=m-1-1; c<n; c++) { //skipping 0 index
            out.add(matrix[c][m-1]);
        }
        for(int r=n-1-1; r>=0; r--) {
            out.add(matrix[m-1][r]);
        }
        for(int c=n-1-1; c>=0+1; c--) {
            out.add(matrix[c][0]);
        }
        return out;
    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(s.spiralOrder(mat));
        
    }
}

/*
Output:

[1, 2, 3, 6, 9, 8, 7, 4]

=== Code Execution Successful ===

[1, 2, 3]

=== Code Execution Successful ===
*/
