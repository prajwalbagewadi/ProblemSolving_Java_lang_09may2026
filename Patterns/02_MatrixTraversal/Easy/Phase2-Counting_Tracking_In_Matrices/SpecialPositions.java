//Question: https://leetcode.com/problems/special-positions-in-a-binary-matrix/description/

/* 
1582. Special Positions in a Binary Matrix

Given an m x n binary matrix mat, return the number of special positions in mat.

A position (i, j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0 (rows and columns are 0-indexed).

Example 1:
Input: mat = [[1,0,0],[0,0,1],[1,0,0]]
Output: 1
Explanation: (1, 2) is a special position because mat[1][2] == 1 and all other elements in row 1 and column 2 are 0.

Example 2:
Input: mat = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
Explanation: (0, 0), (1, 1) and (2, 2) are special positions.
 
Constraints:
m == mat.length
n == mat[i].length
1 <= m, n <= 100
mat[i][j] is either 0 or 1.
*/

class Solution {
    public int numSpecial(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int result = 0;
        int col = 0;
        int rowcnt,colcnt;
        for(int i=0; i<n; i++) {
            rowcnt=0;
            colcnt=0;
            for(int j=0; j<m; j++) {
                System.out.println("r="+i+" c="+j);
                if(mat[i][j]==1) {
                    System.out.println("mat[i][j]="+mat[i][j]);
                    col=j;
                    rowcnt++;
                }
            }
            for(int j=0; j<m; j++) {
                System.out.println("r="+j+" c="+i);
                if(mat[j][col]==1) {
                    System.out.println("mat[j][i]="+mat[j][i]);
                    colcnt++;
                }
            }
            if(rowcnt==1 && colcnt==1) {
                result++;
            }
        }
        return result;
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
        //int[][] in = {{1,0,0},{0,0,1},{1,0,0}};
        //int[][] in = {{1,0,0},{0,1,0},{0,0,1}};
        //int[][] in = {{0,0,0,1},{1,0,0,0},{0,1,1,0},{0,0,0,0}};
        int[][] in = {{0,0,1,0},
                      {0,0,0,0},
                      {0,0,0,0},
                      {0,1,0,0}};
        int[][] in = {{0,0},{0,0},{1,0}};
        Solution s = new Solution();
        System.out.println(s.numSpecial(in));
    }
}

/*
Testcase failed:
[[0,0,0,1],[1,0,0,0],[0,1,1,0],[0,0,0,0]]
expected:
2

[[0,0,1,0],[0,0,0,0],[0,0,0,0],[0,1,0,0]]
expected:
2

[[0,0],[0,0],[1,0]]
expected:
1
*/

/*
Output:

Start small. Ship something.
2

=== Code Execution Successful ===

Start small. Ship something.
 00
 10
 20
 30
 01
 11
 21
 31
 02
 12
 22
 32
 03
 13
 23
 33
0

=== Code Execution Successful ===

Start small. Ship something.
 00
 10
 20
 01
 11
 21
 02
 12
 22
3

=== Code Execution Successful ===

Start small. Ship something.
 00
 10
 20
 01
 11
 21
 02
 12
 22
1

=== Code Execution Successful ===
*/
