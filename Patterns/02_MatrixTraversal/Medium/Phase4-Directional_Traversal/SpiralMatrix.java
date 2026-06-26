//Question: https://leetcode.com/problems/spiral-matrix/description/

/*
54. Spiral Matrix

Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]


Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 
Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
*/

import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> spiralOrder(int [][] matrix) {
        List<Integer> out = new ArrayList<>();
        int top=0;
        int right=matrix[0].length-1;    
        while(top<=right) {
            for(int c=top; c<=right; c++) {
                out.add(matrix[top][c]);
            }
            top++;
            right--;
        }
        return out;
    }
}

/*
class Solution {
    public List<Integer> spiralOrder(int [][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int top=0;
        int left=0;
        int bottom=m-1;
        int right=m-1;
        List<Integer> out = new ArrayList<>();
        
        //while(top<=bottom && left<=right) { // inner ring
        while(top<=bottom) {
            for(int c=top; c<m; c++) {
                out.add(matrix[top][c]); //top
            }
            //top++;
            for(int r=top+1; r<n; r++) { //skipping
                out.add(matrix[r][right]); //right
            }
            //right--;
            for(int c=bottom-1; c>=0; c--) {
                out.add(matrix[bottom][c]); //bottom
            }
            bottom--;
            for(int r=bottom-1; r>=1; r--) {
                out.add(matrix[r][left]); //left
            }
            top++;
            right--;
            left++;
            bottom--;
        }
        return out;
    }
}
*/

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(s.spiralOrder(mat));
        
    }
}

/*
Notes:
0   2 
123 0
456
789 2

Start=0
End=3

While Top <= Bottom 

Top=Start
For c=Top c<End c++
Matrix[Top][c]
Prints 1,2,3


Right=End-1 (cols end)
For r=Top+1 r<End r++
Matrix[r][Right]
Prints 6,9


Bottom=End-1 (rows end)
For c=Bottom-1 c>=Start c--
Matrix[Bottom][c]
Prints 8,7


Left=Start (cols start)
For r=Bottom-1 >=Start+1 r--
Matrix[r][Left]
Prints 4


Top++ so Top=1
Right-- so Right=1
Bottom-- so Bottom=1
Left++ so Left=1

123
456
789

Start=0
End=3

Top=0 
For c=top c<End c++
Prints 1,2,3
Top++ so Top=1

Right=colsEnd-1
For r= r>=0 r--
Prints 6,9
Right-- so Right=1

Bottom=colsEnd-1
For c=Bottom-1 c<


*/

/*
Output:

[1, 2, 3, 5]

=== Code Execution Successful ===

[1, 2]

=== Code Execution Successful ===

[1, 2, 3, 6, 9, 8, 7]

=== Code Execution Successful ===

[1, 2, 3, 9, 9, 8, 7, 5, 6, 5, 8, 5, 4, 5]

=== Code Execution Successful ===

[1, 2, 3, 6, 9, 8, 7, 4]

=== Code Execution Successful ===

[1, 2, 3]

=== Code Execution Successful ===
*/
