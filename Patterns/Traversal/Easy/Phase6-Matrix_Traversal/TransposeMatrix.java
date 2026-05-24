//Question: https://leetcode.com/problems/transpose-matrix/

/*
867. Transpose Matrix

Given a 2D integer array matrix, return the transpose of matrix.

The transpose of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[1,4,7],[2,5,8],[3,6,9]]

Example 2:
Input: matrix = [[1,2,3],[4,5,6]]
Output: [[1,4],[2,5],[3,6]]
 
Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 1000
1 <= m * n <= 105
-109 <= matrix[i][j] <= 109
*/

class Solution {
    public int[][] transpose(int[][] matrix) {
        int[][] trans = new int[matrix.length][matrix[0].length];
        for(int r=0; r<matrix.length; r++) {
            for(int c=0; c<matrix[r].length; c++) { 
                trans[r][c] = matrix[c][r];
            }
        }
        return trans;
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("hello world.");
        //int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] mat = {{1,2,3},{4,5,6}};
        Solution s = new Solution();
        for(int[] r : s.transpose(mat)) {
            for(int c : r) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}