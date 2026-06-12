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

/*
Steps
1. start.
2. Take input 2D array int[][]mat.
3. Create new var int n=mat.length.
4. Create new var int m=mat[0].length.
5. Create new var int result=0;
6. Create new var int col=0.
7. Create new vars int rowcnt,colcnt.
8. For int i=0 to i<n(numofrows) (increament i++).
9. Set rowcnt=0.
10. Set colcnt=0.
11. For int j=0 to j<m(numofcols) (increament j++).
12. Check if mat[i][j]==1.
13. Set col=j.
14. Increment rowcnt++.
15. For int j=0 to j<m(numofrows) (increament j++).
16. Check if mat[j][col]==1.
17. Increment colcnt++.
18. Check if rowcnt==1 && colcnt==1.
19. Increment result++.
20. Return result.
21. Stop.
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
            for(int j=0; j<n; j++) {
                System.out.println("r="+j+" c="+i);
                if(mat[j][col]==1) {
                    System.out.println("mat[j][i]="+mat[j][col]);
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
        //int[][] in = {{0,0,1,0},{0,0,0,0},{0,0,0,0},{0,1,0,0}};
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
r=0 c=0
r=0 c=1
r=0 c=0
r=1 c=0
r=2 c=0
mat[j][i]=1
r=1 c=0
r=1 c=1
r=0 c=1
r=1 c=1
r=2 c=1
mat[j][i]=1
r=2 c=0
mat[i][j]=1
r=2 c=1
r=0 c=2
r=1 c=2
r=2 c=2
mat[j][i]=1
1

=== Code Execution Successful ===

Start small. Ship something.
r=0 c=0
r=0 c=1
r=0 c=0
r=1 c=0
r=2 c=0
mat[j][i]=1
r=1 c=0
r=1 c=1
r=0 c=1
r=1 c=1
r=2 c=1
mat[j][i]=0
r=2 c=0
mat[i][j]=1
r=2 c=1
r=0 c=2
r=1 c=2
r=2 c=2
ERROR!
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 2 out of bounds for length 2
	at Solution.numSpecial(Main.java:48)
	at Main.main(Main.java:69)

=== Code Exited With Errors ===*

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