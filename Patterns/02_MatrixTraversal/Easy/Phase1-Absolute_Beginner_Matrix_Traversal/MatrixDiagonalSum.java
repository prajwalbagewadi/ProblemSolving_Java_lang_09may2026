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

class Solution {
    public int diagonalSum(int[][] mat) {
        int sum=0,c=mat[0].length;
        for(int i=0; i<mat.length*c; i++) {
           //primarydiag and secondarydiag combined
           if(i/c==i%c || i/c+i%c==c-1 && i/c!=mat.length/2 && i%c!=c/2) {
            sum += mat[i/c][i%c];
           }
        }
        return sum;
    }
}

class Solution {
    public int diagonalSum(int[][] mat) {
        int sum=0,c=mat[0].length;
        for(int i=0; i<mat.lengt; i++) {
           
        }
        return sum;
    }
}

class Main {
    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
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
*/

/*
output:

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