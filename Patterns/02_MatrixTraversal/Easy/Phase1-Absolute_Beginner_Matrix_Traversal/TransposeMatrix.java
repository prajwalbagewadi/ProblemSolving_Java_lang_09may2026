//Question: https://leetcode.com/problems/transpose-matrix/description/

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
        int[][] mat;
        int c;
        if(matrix.length!=matrix[0].length) {
             mat = new int[matrix[0].length][matrix.length];
             c = matrix[0].length;
             for(int i=0; i<c*matrix.length; i++) {
                 System.out.println("r="+i/c+" c="+i%c);
                 mat[i/c][i%c] = matrix[i/c][i%c];
             }
        }
        else {
            mat = new int[matrix.length][matrix[0].length];
            c = matrix[0].length;
            for(int i=0; i<matrix.length*c; i++) {
                mat[i/c][i%c] = matrix[i%c][i/c];
            }
        }
        return mat;
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        //int[][] mat = {{1,2,3},{4,5,6}};
        Solution s = new Solution();
        for(int[] i : s.transpose(mat)) {
            for(int j : i) {
                System.out.print(j);
            }
            System.out.println();
        } 
        
    }
}


/*
Output:

can't handle edge case 3*2 matrix
Start small. Ship something.
147
258
369

=== Code Execution Successful ===

Start small. Ship something.
r=0 c=0
r=0 c=1
r=0 c=2
ERROR!
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 2 out of bounds for length 2
	at Solution.transpose(Main.java:35)
	at Main.main(Main.java:54)

=== Code Exited With Errors ===

Start small. Ship something.
ERROR!
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 2 out of bounds for length 2
	at Solution.transpose(Main.java:37)
	at Main.main(Main.java:48)

=== Code Exited With Errors ===
*/
