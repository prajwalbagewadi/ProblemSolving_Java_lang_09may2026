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
    public List<Integer> spiralOrder(int [][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int top=0;
        int left=0;
        int bottom=m-1;
        int right=m-1;
        List<Integer> out = new ArrayList<>();
        while(top<=bottom && left<=right) { // inner ring
            for(int c=top; c<m; c++) {
                out.add(matrix[top][c]); //top
            }
            top++;
            for(int r=right; r<n; r++) { //skipping
                out.add(matrix[r][right]); //right
            }
            right--;
            for(int c=bottom; c>=0; c--) {
                out.add(matrix[bottom][c]); //bottom
            }
            bottom--;
            for(int r=left; r>=0+1; r--) {
                out.add(matrix[r][left]); //left
            }
            left++;
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

[1, 2, 3, 9, 9, 8, 7, 5, 6, 5, 8, 5, 4, 5]

=== Code Execution Successful ===

[1, 2, 3, 6, 9, 8, 7, 4]

=== Code Execution Successful ===

[1, 2, 3]

=== Code Execution Successful ===
*/
