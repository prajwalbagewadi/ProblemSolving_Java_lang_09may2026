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
       int top=0;
       int right=n-1;
       int bottom=n-1;
       int left=0;
       int cnt=1;
       
       while(top<=bottom && left<=right) {
            //top
            for(int i=left; i<=right; i++) {
                out[top][i]=cnt;
                cnt++;
            }
            //right
            for(int i=top+1; i<=bottom; i++) {
                out[i][right]=cnt;
                cnt++;
            }
            //bottom
            for(int i=right-1; i>=left; i--) {
                out[bottom][i]=cnt;
                cnt++;
            }
            //left
            for(int i=bottom-1; i>=top+1; i--) {
                out[i][left]=cnt;
                cnt++;
            }
            top++;
            right--;
            bottom--;
            left++;
       }
       return out;
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
        int n=3;
        Solution s = new Solution();
        for(int[] i: s.generateMatrix(n)) {
            for(int j : i) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}

/*
output:

Start small. Ship something.
123
894
765

=== Code Execution Successful ===

Start small. Ship something.
123
804
765

=== Code Execution Successful ===

*/
