//Question: https://leetcode.com/problems/spiral-matrix-ii/description/

/* 
59. Spiral Matrix II

Given a positive integer n, generate an n x n matrix filled with elements from 1 to n_Square(2) in spiral order.

Example 1:
Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]

Example 2:
Input: n = 1
Output: [[1]]

Constraints:
1 <= n <= 20
*/

class Solution {
    public int[][] generateMatrix(int n) {
       int[][] out = new int[n][n];
       for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            int top=0;
            int right=n-1;
            int bottom=n-1;
            int left=0;
        }
       }
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
    }
}