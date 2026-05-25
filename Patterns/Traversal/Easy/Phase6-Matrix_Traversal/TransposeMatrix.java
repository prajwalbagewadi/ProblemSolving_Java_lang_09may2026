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

/*
Steps:
1. Start.
2. Take input 2d array int[][] matrix.
3. Create a new 2d array int[][] trans. 
4. Check if matrix.length!=matrix[0].length.
5. Set size of trans = new int[matrix[0].length][matrix.length].
6. For r=0 to matrix.length (increament r++)
7. For c=0 to matrix[0].length (increment c++)
8. Set trans[c][r] = matrix[r][c]. //transpose formula
9. Else Set size trans = new int[matrix.length][matrix[0].length].
10. For r=0 to matrix.length (increament r++)
11. For c=0 to matrix[0].length (increment c++)
12. Set trans[r][c] = matrix[c][r].
13. Return trans.
14. Stop.
*/

class Solution {
    public int[][] transpose(int[][] matrix) {
        int[][] trans;
        if(matrix.length!=matrix[0].length) {
            //System.out.println("n!=m");
            trans = new int[matrix[0].length][matrix.length];
            for(int r=0; r<matrix.length; r++) {
                //System.out.println("r"+r);
                for(int c=0; c<matrix[0].length; c++) {
                    //System.out.println("c"+c);
                    trans[c][r] = matrix[r][c];
               }
            }
        } 
        else {
            trans = new int[matrix.length][matrix[0].length];
            for(int r=0; r<matrix.length; r++) {
                for(int c=0; c<matrix[r].length; c++) {
                    trans[r][c] = matrix[c][r];
               }
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
                System.out.print(" "+c);
            }
            System.out.println();
        }
    }
}

/*
Time Complexity:
Nested loops -> to build result.
O(n×m)
*/
/*
notes:
A[r][c] = AT[c][r];
*/

/*
hello world.
n!=m
r0
c0
c1
c2
r1
c0
c1
c2
 1 4
 2 5
 3 6

=== Code Execution Successful ===

Wrong logic
hello world.
n!=m
r0
c0
c1
r1
c0
c1
r2
c0
ERROR!
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 2 out of bounds for length 2
	at Solution.transpose(Main.java:36)
	at Main.main(Main.java:58)

=== Code Exited With Errors ===


hello world.
ERROR!
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 2 out of bounds for length 2
	at Solution.transpose(Main.java:33)
	at Main.main(Main.java:55)

=== Code Exited With Errors ===
*/
