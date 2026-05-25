//Question: https://leetcode.com/problems/flipping-an-image/description/

/*
832. Flipping an Image

Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.

To flip an image horizontally means that each row of the image is reversed.

For example, flipping [1,1,0] horizontally results in [0,1,1].
To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.

For example, inverting [0,1,1] results in [1,0,0].
 
Example 1:
Input: image = [[1,1,0],[1,0,1],[0,0,0]]
Output: [[1,0,0],[0,1,0],[1,1,1]]
Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]

Example 2:
Input: image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 
Constraints:
n == image.length
n == image[i].length
1 <= n <= 20
images[i][j] is either 0 or 1.
*/

class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int[][] flip = new int[image.length][image[0].length];
        
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("hello world.");
        int[][] image = {{1,1,0},{1,0,1},{0,0,0}};
        Solution s = new Solution();
        for(int[] r : s.flipAndInvertImage(image)) {
            for(int c : r) {
                System.out.print(" "+c);
            }
            System.out.println();
        }
    }
}

/*
Notes: [1,0,0],[0,1,0],[1,1,1]
110     100
101  -> 010
000     111

Flipping an Image: Reverse each row and invert every bit.
0 -> 1
1 -> 0

Original: 1 0 1
Reverse:  1 0 1
Invert:   0 1 0
Result: 0 1 0.

Original: 1 1 0
Reverse:  0 1 1
Invert:   1 0 0
Result: 1 0 0.
*/