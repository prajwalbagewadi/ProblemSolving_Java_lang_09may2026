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
        
        //corners
        int top=0;
        int right=matrix[0].length-1;    
        int bottom=matrix.length-1;
        int left=0;
        
        while(top<=bottom && left<=right) {
            //top
            for(int i=left; i<=right; i++) {
                out.add(matrix[top][i]);
            }
            //right
            for(int i=top+1; i<=bottom; i++) {
                out.add(matrix[i][right]); //right (6,9)
            }
            if(right!=bottom) {
                if(top!=bottom) {
                    //bottom
                    for(int i=right-1; i>=left; i--) {
                        out.add(matrix[bottom][i]);
                    }
                }
                if(left!=right) {
                    //left
                    for(int i=bottom-1; i>top+1; i--) {
                        out.add(matrix[i][left]);
                    }
                }
            }
            else {
                //bottom
                for(int i=right-1; i>=left; i--) {
                    out.add(matrix[bottom][i]);
                }
               //left
               for(int i=bottom-1; i>=top+1; i--) {
                   out.add(matrix[i][left]);
               }
            }
            top++;
            right--;
            bottom--;
            left++;
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
        //int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] mat = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(s.spiralOrder(mat));
        
    }
}

/*
Testcase failed:
[[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Expected:
[1,2,3,4,8,12,11,10,9,5,6,7]
*/

/*
Notes:

    0 | 1 | 2 | 3
------------------
0 | 1 | 2 | 3 | 4
1 | 5 | 6 | 7 | 8
2 | 9 | 10| 11| 12

top=0
right=matrix[0].length-1
bottom=matrix.length-1;
left=0

While(top<=bottom && left<=right) {

//Top
for(int i=left; i<=right; i++) {
    System.out.println(matrix[top][i]);
    //1,2,3,4
}

//right
for(int i=top+1; i<=bottom; i++) {
    System.out.println(matrix[i][right]);
    //8,12
}

//bottom 
for(int i=right-1; i>=left; i--) {
    System.out.println(matrix[bottom][i]);
}

//left
for(int i=bottom-1; i>=top+1; i--) {
    System.out.println(matrix[i][left]);
}

top++;
right--;
bottom--;
left++;

}

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

[1, 2, 3, 4, 8, 12, 11, 10, 9, 6, 7]

=== Code Execution Successful ===

[1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7, 6]

=== Code Execution Successful ===

[1, 2, 3, 6, 9, 8, 7, 4, 5]

=== Code Execution Successful ===

[1, 2, 3, 6, 9, 8, 7, 6]

=== Code Execution Successful ===

[1, 2, 3, 6, 9, 8, 7, 5]

=== Code Execution Successful ===

[1, 2, 3, 6, 9, 5, 8]

=== Code Execution Successful ===

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
