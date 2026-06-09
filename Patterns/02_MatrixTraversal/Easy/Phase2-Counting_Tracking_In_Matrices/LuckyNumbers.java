//Question: https://leetcode.com/problems/lucky-numbers-in-a-matrix/

/* 
1380. Lucky Numbers in a Matrix

Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.

A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

Example 1:
Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column.
Example 2:
Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
Output: [12]
Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.

Example 3:
Input: matrix = [[7,8],[1,2]]
Output: [7]
Explanation: 7 is the only lucky number since it is the minimum in its row and the maximum in its column.
 
Constraints:
m == mat.length
n == mat[i].length
1 <= n, m <= 50
1 <= matrix[i][j] <= 105.
All elements in the matrix are distinct.
*/

/*
Steps:
1. Start.
2. Take input 2D array int[][] matrix.
3. Create new List<Integer> out = new ArrayList<>();
4. Create new int n = matrix.length;
5. Create new int m = matrix[0].length.
6. Create new int min.
7. Create new int col = 0.
8. Create new int max.
9. For int i=0 to i<n (increament i++)
10. Set min = matrix[i][i%m].
11. For int j=0; to j<m (increament j++)
12. Check if matrix[i][j] < min.
13. Set col = j.
14. Set min = matrix[i][j].
15. Set max = min.
16. For int k=0; to k<n (increament k++)
17. Check if matrix[k][col] > max.
18. Set max = matrix[k][col].
19. Check if min == max.
20. Add out.add(max).
21. Return out.
22. Stop.
*/

import java.util.List;
import java.util.ArrayList;

class Solution {
  public List<Integer> luckyNumbers(int[][] matrix) {
    List<Integer> out = new ArrayList<Integer>();
    int n = matrix.length;
    int m = matrix[0].length;
    int min;
    int col=0;
    int max;
    for(int i=0; i<n; i++) {
        min=matrix[i][i%m];
        for(int j=0; j<m; j++) {
            if(matrix[i][j]<min) {
                col=j;
                min=matrix[i][j];
            }
        }
        max=min;
        for(int k=0; k<n; k++) {
            if(matrix[k][col]>max) {
                max=matrix[k][col];
            }
        }
        if(min==max) {
            out.add(max);
        }
    }
    return out;
  }
}

class Main {
  public static void main(String[] args) {
    System.out.println("Start small. Ship something.");
    Solution s = new Solution();
    //int[][] in = {{3,7,8},{9,11,13},{15,16,17}};
    //int[][] in = {{7,8},{1,2}};  
    //int[][] in = {{5, 1},{5, 1}}; invalid case.
    //int[][] in = {{1,10,4,2},{9,3,8,7},{15,16,17,12}};
    //int[][] in = {{3,6},{7,1},{5,2},{4,8}};
    int[][] in = {{56216},{63251},{75772},{1945},{27014}};
    for(int i : s.luckyNumbers(in)) {
      System.out.println(i);
    }
  }
}

/*
Time complexity:
loop 1 -> runs rows.
loop 2 -> find min in each row.
loop 3 -> find max in col.
O(n*m+n*n)
O(n*(m+n))
O(nm+square(n))
O(square(n))
*/

/*
Testcase failed:

int[][] in = {{56216},{63251},{75772},{1945},{27014}};
Expected:
[75772]

int[][] in = {{1,10,4,2},{9,3,8,7},{15,16,17,12}};
Expected:
12
*/


/*
Output:

Start small. Ship something.
75772

=== Code Execution Successful ===

Start small. Ship something.
12

=== Code Execution Successful ===

Start small. Ship something.

=== Code Execution Successful ===

Start small. Ship something.
ERROR!
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
	at Solution.luckyNumbers(Main.java:44)
	at Main.main(Main.java:70)

=== Code Exited With Errors ===

Start small. Ship something.

Start small. Ship something.
min
r=0
c=0
min
r=1
c=1
min
r=2
c=2

Start small. Ship something.
min
r=0
c=0
max
r=0
c=0
min
r=1
c=1
max
r=1
c=1
min
r=2
c=2
max
r=2
c=2
3
11
17

ERROR!
Main.java:41: error: cannot find symbol
            if(matrix[r][r%c]<min) {
                           ^
  symbol:   variable c
  location: class Solution
ERROR!
Main.java:42: error: cannot find symbol
                if(matrix[r%c][r]>max) {
                            ^
  symbol:   variable c
  location: class Solution
ERROR!
Main.java:43: error: cannot find symbol
                    out.add(matrix[r][r%c]);
                                        ^
  symbol:   variable c
  location: class Solution
3 errors

=== Code Exited With Errors ===
*/