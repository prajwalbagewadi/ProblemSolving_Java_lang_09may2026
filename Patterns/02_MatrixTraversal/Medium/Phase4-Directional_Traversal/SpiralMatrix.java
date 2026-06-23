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
    public List<Integer> spiralOrder([][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int top=0;
        int left=0;
        int bottom=m-1;
        int right=m-1;
        List<Integer> out = new ArrayList<>();
        while(top<bottom && left<right) { // inner ring
            for(int r=0; r<m; r++) {
                out.add(matrix[top][r]); //top
            }
            for(int c=m-1-1; c<n; c++) { //skipping
                out.add(matrix[c][right]); //right
            }
            for(int r=n-1-1; r>=0; r--) {
                out.add(matrix[bottom][r]); //bottom
            }
            for(int c=n-1-1; c>=0+1; c--) {
                out.add(matrix[c][left]); //left
            }
            top++;
            left++;
            bottom--;
            right--;
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
