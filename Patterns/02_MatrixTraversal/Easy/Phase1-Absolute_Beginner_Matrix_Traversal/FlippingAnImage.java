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
        int[][] out = new int[image.length][image.length];
        int r=0;
        for(int i=0; i<image.length; i++) {
            for(int j=image.length-1; j>=0; j--) {
                if(image[i][j]==0) {
                    out[i][r] = 1;
                }
                else {
                    out[i][r] = 0;
                }     
                r++;
            }
        }
        return out;
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
        int [][] img = {{1,1,0},{1,0,1},{0,0,0}};
        Solution s = new Solution();
        for(int[] i : s.flipAndInvertImage(img)) {
            for(int j : i) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}

/*
Output:

Start small. Ship something.
ERROR!
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
	at Solution.flipAndInvertImage(Main.java:44)
	at Main.main(Main.java:58)

=== Code Exited With Errors ===

Start small. Ship something.
ERROR!
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index -1 out of bounds for length 3
	at Solution.flipAndInvertImage(Main.java:40)
	at Main.main(Main.java:53)

=== Code Exited With Errors ===
*/
