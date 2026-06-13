//Question: https://leetcode.com/problems/reshape-the-matrix/description/

/* 
566. Reshape the Matrix

In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.

You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of columns of the wanted reshaped matrix.

The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.

If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

Example 1:
Input: mat = [[1,2],[3,4]], r = 1, c = 4
Output: [[1,2,3,4]]

Example 2:
Input: mat = [[1,2],[3,4]], r = 2, c = 4
Output: [[1,2],[3,4]]
 
Constraints:
m == mat.length
n == mat[i].length
1 <= m, n <= 100
-1000 <= mat[i][j] <= 1000
1 <= r, c <= 300
*/

/*
Steps:
1. Start.
2. Take input 2D array int[][] mat and int r and int c.
3. Create new 2D array int[][] out and set it to int[][] out = mat.
4. Create new int n = mat.length.
5. Create new int m = mat[0].length.
6. Create new int k = 0;
7. Check if r*c == n*m.
8. Set out = new int[r][c].
9. For int i=0 to i<n*m (increament i++).
10. Set out[k/c][k%c] = mat[i/m][i%m].
11. Increament k++.
12. Return out.
13. Stop.
*/

class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] out = mat;
        int n = mat.length;
        int m = mat[0].length;
        int k=0;
        if(r*c==n*m) {
            out = new int[r][c];
            for(int i=0; i<n*m; i++) {
                System.out.println(mat[i/m][i%m]);
                out[k/c][k%c] = mat[i/m][i%m];
                k++;
            }
        }
        return out;
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
        Solution s = new Solution();
        int[][] in = {{1,2},{3,4}};
        int r = 1;
        int c = 4;
        for(int[] i: s.matrixReshape(in,r,c)) {
            for(int j: i) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}

/*
Time Complexity:
first loop costs - n*m
O(n*m)
*/

/*
Notes:

class Main {
    public static void main(String[] args) {
        System.out.println(0/2); //0
        System.out.println(0%2); //0
        System.out.println(0/4); //0
        System.out.println(0%4); //0
        
        System.out.println(1/2); //0
        System.out.println(1%2); //1
        System.out.println(1/4); //0
        System.out.println(1%4); //1
        
        System.out.println(2/2); //1
        System.out.println(2%2); //0
        System.out.println(2/4); //0
        System.out.println(2%4); //2
        
        System.out.println(3/2); //1
        System.out.println(3%2); //1
        System.out.println(3/4); //0
        System.out.println(3%4); //3
    }
}
*/

/*
Output:

Start small. Ship something.
1
2
3
4
1234

=== Code Execution Successful ===

Start small. Ship something.
4444

=== Code Execution Successful ===

Start small. Ship something.
ERROR!
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 2 out of bounds for length 2
	at Solution.matrixReshape(Main.java:40)
	at Main.main(Main.java:57)

=== Code Exited With Errors ===

ERROR!
Start small. Ship something.
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 2 out of bounds for length 2
	at Solution.matrixReshape(Main.java:37)
	at Main.main(Main.java:51)

=== Code Exited With Errors ===

Start small. Ship something.
ERROR!
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 1 out of bounds for length 1
	at Solution.matrixReshape(Main.java:37)
	at Main.main(Main.java:54)

=== Code Exited With Errors ===
*/