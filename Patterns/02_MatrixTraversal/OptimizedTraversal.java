//Optimized Matrix Traversal

/*
If you want to traverse every element of a 2D array, you cannot do better than visiting each element once.

For a matrix with R rows and C columns, the optimal time complexity is:
O(R * C)

Because there are R * C elements. 

With a single loop, you can treat the matrix as a flattened 1D array:
- Index goes from 0 to R * C - 1.
- Row = index / C.
- Col = index % C.
*/

/*
Example: For 3 * 4 matrix:

class Main {
    public static void main(String[] args) {
        int c=4;
        for(int i=0; i<12; i++) {
            System.out.println("index:"+i+" row="+(i/c)+" col="+(i%c));
        }
    }
}

-------------------------
index    | row   | col
-------------------------
index:0  | row=0 | col=0 p
index:1  | row=0 | col=1
index:2  | row=0 | col=2
index:3  | row=0 | col=3 s
--------------------------
index:4  | row=1 | col=0
index:5  | row=1 | col=1 p
index:6  | row=1 | col=2 s
index:7  | row=1 | col=3
--------------------------
index:8  | row=2 | col=0
index:9  | row=2 | col=1 s
index:10 | row=2 | col=2 p
index:11 | row=2 | col=3
*/

// Online Java Compiler
// Use this editor to write, compile and run your Java code online

// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class TwoDimensionalArray {
    public void traverse(int[][] matrix) {
        int c=matrix[0].length;
        for(int i=0; i<matrix.length*matrix[0].length; i++) {
            System.out.print(" "+matrix[i/c][i%c]);
        }
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        TwoDimensionalArray t = new TwoDimensionalArray();
        t.traverse(matrix);
    }
}

/*
Output:
Start small. Ship something.
 1 2 3 4 5 6 7 8 9 10 11 12
=== Code Execution Successful ===
*/