//Question: https://leetcode.com/problems/shift-2d-grid/description/

/*
1260. Shift 2D Grid

Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.

In one shift operation:
Element at grid[i][j] moves to grid[i][j + 1].
Element at grid[i][n - 1] moves to grid[i + 1][0].
Element at grid[m - 1][n - 1] moves to grid[0][0].
Return the 2D grid after applying shift operation k times.

Example 1:
Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
Output: [[9,1,2],[3,4,5],[6,7,8]]

Example 2:
Input: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
Output: [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]

Example 3:
Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
Output: [[1,2,3],[4,5,6],[7,8,9]]
 
Constraints:
m == grid.length
n == grid[i].length
1 <= m <= 50
1 <= n <= 50
-1000 <= grid[i][j] <= 1000
0 <= k <= 100
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
    //public int[][] shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int r = 0;
        int c = 0;
        int size = n*m;
        List<List<Integer>> matrix = new ArrayList<>();
        int i=0;
        while(i<size) {
            Integer[] outarr = new Integer[m];
            r = (i+k)%size;
            c = (i+k)%size;
            
           //System.out.println(grid[r/m][c%m]);
           //outarr[r/m][c%m]=grid[i/m][i%c];
           //matrix.get(r/m).add(c/m,grid[i/m][i%m]);
           outarr[c%m]=grid[i/m][i%m];
           if(i%m==0) {
               matrix.add(Arrays.asList(outarr));
               outarr = new Integer[m];
               //out.add(arr);
               //arr.clear(); //clears temp at every third interval.
                
            }
           i++;
        }
        return matrix;
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
        Solution s = new Solution();
        int[][] in = {{1,2,3},{4,5,6},{7,8,9}};
        int k = 1;
        System.out.println(s.shiftGrid(in,k));
        // for(List<Integer> i: s.shiftGrid(in,k)) {
        //     for(Integer j: i) {
        //         System.out.print(j);
        //     }
        //     System.out.println();
        // }
    }
}

/*
Notes:

Formula: 
- New array index = (i + k) % size
- New array index = (old index + k).
- Problem when index reaches at the end. the New index goes to N+1 (8+1=9) 'getting ArrayIndexOutOfBound'.
- We need circling back to start or Wrapping.(8+1 should go to 0).
- But After the last box, you come back to the first one.
- So Whenever you go past N, you just restart from 0.
- That 'Restart' is what % N does.
- newIndex = (oldIndex + k) % N.
- Stop at every third interval (i%3==0)

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Main {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
        List<List<String>> out = new ArrayList<List<String>>();
        List<String> words = Arrays.asList("apple","banana","cherry");
        out.add(words);
        System.out.println(out);
    }
}

/*
Output:

Start small. Ship something.
[[null, 1, null], [null, 4, null], [null, 7, null]]

=== Code Execution Successful ===

ERROR!
Main.java:59: error: incompatible types: no instance(s) of type variable(s) T exist so that List<T> conforms to ArrayList<Integer>
               matrix.add(Arrays.asList(outarr));
                     ^
  where T is a type-variable:
    T extends Object declared in method <T>asList(T...)
ERROR!
Main.java:67: error: cannot find symbol
        return out;
               ^
  symbol:   variable out
  location: class Solution
Note: Some messages have been simplified; recompile with -Xdiags:verbose to get full output
2 errors

=== Code Exited With Errors ===

Start small. Ship something.
2
3
4
5
6
7
8
9
1
[[9, 1], [9, 1], [9, 1]]

=== Code Execution Successful ===

Start small. Ship something.
[[apple, banana, cherry]]

=== Code Execution Successful ===
*/

/*
Output:

Start small. Ship something.
912
345
678

=== Code Execution Successful ===

Start small. Ship something.
ERROR!
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 9 out of bounds for length 3
	at Solution.shiftGrid(Main.java:45)
	at Main.main(Main.java:57)

=== Code Exited With Errors ===
*/
