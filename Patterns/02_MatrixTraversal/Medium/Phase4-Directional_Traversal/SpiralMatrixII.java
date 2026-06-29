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

/*
Steps:
1. Start.
2. Take input int n.
3. Create a new 2D array int[][] out = new int[n][n].
4. Create new int top = 0.
5. Create new int right = n-1.
6. Create new int bottom = n-1.
7. Create new int left = 0.
8. Create new int cnt = 1.
9. While top<=bottom && left<=right.
10. For int i=left to i<=right (increament i++). //top
11. Insert into out[top][i] = cnt.
12. Increament cnt++.
13. For int i=top+1 to i<=bottom (increament i++). //right
14. Insert into out[i][right] = cnt.
15. Increament cnt++.
16. For int i=right-1 to i>=left (decreament i--). //bottom
17. Insert into out[bottom][i] = cnt.
18. Increament cnt++.
19. For int i=bottom-1 to i>=top+1 (decreament i--). //left
20. Insert into out[i][left] = cnt.
21. Increament cnt++.
22. Increament top++.
23. Decrement right--.
24. Decrement bottom--.
25. Increament left++.
26. Return out.
27. Stop.
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
Time Complexity:
O(square(n)).
*/

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
