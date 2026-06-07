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

import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> out = new ArrayList<Integer>();
        int min=0,max=0,c=matrix[0].length;
        for(int r=0; r<matrix.length;
        r++) {
          if(matrix[r%c][r]>max) {
            System.out.println("min");
            System.out.println("r="+r);
            System.out.println("c="+r%c);
            max = matrix[r][r%c];
          }
          if(matrix[r][r%c]<min) {
            System.out.println("max");
            System.out.println("r="+r%c);
            System.out.println("c="+r);
            min = matrix[r][r%c];
          }
          if(min==max) {
            out.add(min);
          }
        }
        return out;
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
        Solution s = new Solution();
        int[][] in = {{3,7,8},{9,11,13},{15,16,17}};
        for(int i : s.luckyNumbers(in)) {
            System.out.println(i);
        }
    }
}

/*
Output:

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