//Previously solved.

//Question: https://leetcode.com/problems/matrix-diagonal-sum/description/

/*
1572. Matrix Diagonal Sum
Solved

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
1 <= mat[i][j] <= 100
*/

// class Solution {
//     public int diagonalSum(int[][] mat) {
//         int sum=0,c=mat[0].length;
//         for(int i=0; i<mat.length*c; i++) {
//            //primarydiag
//            if(i/c==i%c) {
//             sum += mat[i/c][i%c];
//            }
//            if(i/c+i%c==c-1) {
//             sum += mat[i/c][i%c];
//            }
//         }
//         return sum;
//     }
// }

// class Solution {
//     public int diagonalSum(int[][] mat) {
//         int sum=0,c=mat[0].length;
//         for(int i=0; i<mat.length*c; i++) {
//            //primarydiag
//            if(i/c==i%c) {
//             System.out.println("r="+i/c+" c="+i%c);
//             sum += mat[i/c][i%c];
//            }
//            //secondarydiag
//            if(i/c+i%c==c-1 && i/c!=mat.length/2 && i%c!=c/2) {
//             System.out.println("r="+i/c+" c="+i%c);
//             sum += mat[i/c][i%c];
//            }
//         }
//         return sum;
//     }
// }

// class Solution {
//     public int diagonalSum(int[][] mat) {
//         int sum=0,c=mat[0].length;
//         for(int i=0; i<mat.length*c; i++) {
//            //primarydiag and secondarydiag combined
//            if(i/c==i%c || i/c+i%c==c-1 && i/c!=mat.length/2 && i%c!=c/2) {
//             sum += mat[i/c][i%c];
//            }
//         }
//         return sum;
//     }
// }

class Solution {
    public int diagonalSum(int[][] mat) {
        int sum=0,c=mat[0].length-1;
        for(int r=0; r<mat.length; r++) {
           if(r!=c) {
            sum += mat[r][r] + mat[r][c];
           }
           if(r==c) {
               sum += mat[r][c];
           }
           c--;
        }
        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] mat = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        Solution s = new Solution();
        System.out.println(s.diagonalSum(mat));
    }
}

/*
Notes:
Loop i=0 to i<mat.length*mat[0].length
Formula:
row = index / Col.length 
col = index % Col.length

formula for diagonals
Primary diagonal: Row == Col
Secondary diagonal: Row + Col == Col.length - 1. 
Add Condition to stop from traversing through the center again for odd matrix eg: 3*3
check if row != row.length/2 and col != col.length/2

- CURRENT SOLUTION USES TIME COMPLEXITY 0(N*M) OR 0(SQUARE(N)).

Optimizing the Solution to Time Complexity 0(n).
- Given a 3 * 3 matrix 
   0  1  2
 0[1, 2, 3]
 1[4, 5, 6]
 2[7, 8, 9]
 
Diagonals:

Primary Diagonal:
[0,0]
[1,1]
[2,2]

Secondary Diagonal:
[0,2]
[1,1]
[2,0] 

Observations:
- Primary diagonals have [same Row][same Col] that is Row==Col, so we can do matrix[row][row].

- For Secondary diagonals observed that the [Row] travels from 0 to Row.length-1.
- While the [Col] travels from Col.length-1 to 0 

- Observed that if the matrix is of odd Row and Col length. 
- The Center is traversed twice both in primary and secondary diagonal.
- To Stop the second traversal.
- Check if (r!=c) traverse.
- Check if (r==c) traverse. 
- Stopping second traversal.
*/

/*
output:

25

=== Code Execution Successful ===

39

=== Code Execution Successful ===

r=0 c=0
r=0 c=2
r=1 c=1
r=2 c=0
r=2 c=2
25

=== Code Execution Successful ===

r=0 c=0
r=0 c=2
r=1 c=1
r=1 c=2
r=2 c=2
r=2 c=2
33

=== Code Execution Successful ===

r=0 c=0
r=1 c=0
r=1 c=1
r=2 c=2
19

=== Code Execution Successful ===
*/