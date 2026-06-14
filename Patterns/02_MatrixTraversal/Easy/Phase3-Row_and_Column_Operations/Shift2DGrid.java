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

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        List<List<Integer>> out = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        for(int i=0; i<n*m; i++) {
            System.out.println(grid[(i+k)/n*m][(i+k)%n*m]);
        }
        return out;
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
        Solution s = new Solution();
        int[][] in = {{1,2,3},{4,5,6},{7,8,9}};
        int k = 9;
        System.out.println(s.shiftGrid(in,k));
    }
}

/*
Notes:

Formula: new array index = (i + k) % size

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
[[apple, banana, cherry]]

=== Code Execution Successful ===
*/

/*
Output:

Start small. Ship something.
ERROR!
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 9 out of bounds for length 3
	at Solution.shiftGrid(Main.java:45)
	at Main.main(Main.java:57)

=== Code Exited With Errors ===
*/