/*
1030. Matrix Cells in Distance Order

You are given four integers row, cols, rCenter, and cCenter. There is a rows x cols matrix and you are on the cell with the coordinates (rCenter, cCenter).

Return the coordinates of all cells in the matrix, sorted by their distance from (rCenter, cCenter) from the smallest distance to the largest distance. You may return the answer in any order that satisfies this condition.

The distance between two cells (r1, c1) and (r2, c2) is |r1 - r2| + |c1 - c2|.

Example 1:
Input: rows = 1, cols = 2, rCenter = 0, cCenter = 0
Output: [[0,0],[0,1]]
Explanation: The distances from (0, 0) to other cells are: [0,1]

Example 2:
Input: rows = 2, cols = 2, rCenter = 0, cCenter = 1
Output: [[0,1],[0,0],[1,1],[1,0]]
Explanation: The distances from (0, 1) to other cells are: [0,1,1,2]
The answer [[0,1],[1,1],[0,0],[1,0]] would also be accepted as correct.

Example 3:
Input: rows = 2, cols = 3, rCenter = 1, cCenter = 2
Output: [[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
Explanation: The distances from (1, 2) to other cells are: [0,1,1,2,2,3]
There are other answers that would also be accepted as correct, such as [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]].
 
Constraints:
1 <= rows, cols <= 100
0 <= rCenter < rows
0 <= cCenter < cols
*/

/*
Algo:
1. find dist of pair(r,c) from rCenter,cCenter 
2. (r-rCenter)+(c-cCenter)
3. Add r,c,dist to the list<Ele> e.
*/

/*
Steps:
1. Start.
2. Take input int rows, int cols, int rCenter, int cCenter.
3. Create a new ArrayList of class Ele{x,y,dist} ArrayList<Ele> e = new ArrayList<>();
4. Create a 2D array int[][] out = new int[rows*cols][2];
5. For int r=0 to r<rows (increament r++).
6. For int c=0 to c<cols (increament c++).
*/

import java.lang.Math;6. For int i=0 to i<rows (increament i++).
import java.util.ArrayList;
import java.util.List;

class Ele {
    int row;
    int col;
    int dist;
    public Ele(int r, int c, int d) {
        this.row = r;
        this.col = c;
        this.dist = d;
    }
    public void print() {
        System.out.println("["+row+","+col+","+dist+"]");
    }
}

class Mech {
    public ArrayList<Ele> sortDist(ArrayList<Ele> list) {
        for(int i=0; i<list.size(); i++) {
            for(int j=0; j<list.size()-i-1; j++) {
                Ele t1 = list.get(j);
                Ele t2 = list.get(j+1);
                Ele temp;
                if(t1.dist>t2.dist) {
                    temp = t1;
                    list.set(j,t2); //list.set(index,data);
                    list.set(j+1,temp);
                }
            }
        }
        return list;
    }
}

class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        ArrayList<Ele> e = new ArrayList<>();
        int[][] out = new int[rows*cols][2];
        //ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
        //ArrayList<Integer> d = new ArrayList<>();
        for(int r=0; r<rows; r++) {
            for(int c=0; c<cols; c++) {
                e.add(new Ele(r,c,(Math.abs(r-rCenter)+Math.abs(c-cCenter))));
            }
        }
        Mech m = new Mech();
        int i=0;
        for(Ele o : m.sortDist(e)) {
            out[i][0]=o.row; //for index 'i' add row.
            out[i][1]=o.col; //for the same index 'i' add col. 
            i++; //increament.
            //temp.add(o.row);
            //temp.add(o.col);
            //d.add(o.row,o.col);
            //temp.add(new ArrayList(o.row,o.col));
            //for(int i=0; i<rows*cols; i++) {
                //out[i][i%cols]=List.toArray(temp);
                // d.add(o.row,o.col);
                // temp.add(i,d);
            //}
            //o.print();
        }
        //System.out.println(temp);
        return out;
    }
}


class Main {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
        Solution s = new Solution();
        //for(int[] i:s.allCellsDistOrder(1,2,0,0)) {
        for(int[] i:s.allCellsDistOrder(2,2,0,1)) {
            for(int j:i) {
                System.out.print(j);
            }
            System.out.println();
        }
    }
}

/*
Notes:
Distance: (r-rCenter)+(c-cCenter).
- Gives the Distance in negative values.
- Real world Distance can never be a negative value.
- To sol that we the Absolute values.
- Absolute values mean the distance from Zero on the number line. Ignoring weather the number is positive or negative.
- Can be done using math.abs(value). 
- Or |r-rCenter|+|c-cCenter|. math notation.
- Correct java syntax Math.abs(r-rCenter)+Math.abs(c-cCenter).

Sorting:
- Process of arranging data in specific order (Usually ascending or descending) or lexicographical order.
- Most sorting algorithms repeatedly compare elements and move them to their correct positions.
- Eg: [8,3,5].
- compare 8 and 3.
- 8 > 3 - swap.
[3,8,5]
- compare 8 and 5.
- 8 > 5 - swap.
[3,5,8]

- j < size - i - 1 because after each pass, the largest element is already fixed at the end,
so we skip it (-i) and stop before (j+1) goes out of bound (-1).

// Swapping by distances:
   0 1 2 3 
- [1,0,2,1]
- i=0 
- j=0[1] j=0 < 3=4-0-1
- - j=0[1]>j+1[0] - swap;
- - [0,1,2,1]
- - j++
- - j=1[1]>j+1[2] - noSwap;
- - [0,1,2,1]
- - j=2[2]>j+1[1] - swap; 
- - [0,1,1,2];
- i=1 
- j=0[0] j=0 < 2=4-1-1. 

//Add the elements to 2D array.
- for(int i=0; i<rows*cols; i++) {
    forEach(i) {
        out[i][0] = o.row;
        out[i][1] = o.col;
    }
}

// Unoptimized approach.
class Main {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
        //int[] l = {8,3,5,2,9};
        int[] l = {10,1,9,2,8,3,7};
        int temp;
        for(int i=0; i<l.length; i++) {
            for(int j=0; j<l.length; j++) {
                if(l[i]<l[j]) {
                    temp = l[i];
                    l[i] = l[j];
                    l[j] = temp;
                }
            }
        }
        for(int i=0; i<l.length; i++) {
            System.out.print(l[i]);
        }
    }
}

/*
sorting output:

Start small. Ship something.
[0,1,0]
[0,0,1]
[1,1,1]
[1,0,2]
[]
01
00
11
10

=== Code Execution Successful ===

Start small. Ship something.
[0,1,0]
[0,0,1]
[1,1,1]
[1,0,2]
[[0, 0, 1, 1], [0, 0, 1, 1], [0, 0, 1, 1], [0, 0, 1, 1]]
00
00
00
00

=== Code Execution Successful ===

Start small. Ship something.
[0,1,0]
[0,0,1]
[1,1,1]
[1,0,2]
[[0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1], [0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1], [0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1], [0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1], [0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1], [0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1], [0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1], [0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1], [0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1], [0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1], [0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1], [0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1], [0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1], [0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1], [0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1], [0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1]]
00
00
00
00

=== Code Execution Successful ===

Start small. Ship something.
12378910
=== Code Execution Successful ===

Start small. Ship something.
23589
=== Code Execution Successful ===
*/

/*
output:

ERROR!
Main.java:91: error: no suitable method found for toArray(ArrayList<Integer>)
                out[i][i%cols]=List.toArray(temp);
                                   ^
    method Collection.toArray(IntFunction) is not applicable
      (argument mismatch; ArrayList<Integer> cannot be converted to IntFunction)
    method List.toArray(Object[]) is not applicable
      (argument mismatch; ArrayList<Integer> cannot be converted to Object[])
Note: Some messages have been simplified; recompile with -Xdiags:verbose to get full output
1 error

=== Code Exited With Errors ===

ERROR!
Main.java:90: error: incompatible types: int[] cannot be converted to int
                out[i][i%cols] = ae;
                                 ^
1 error

=== Code Exited With Errors ===

Start small. Ship something.
[0,0,1]
[0,1,0]
[1,0,2]
[1,1,1]
00
00

=== Code Execution Successful ===

ERROR!
Main.java:62: error: illegal start of expression
                e.add(new Ele(r,c,(|r-rCenter|+|c-cCenter|)));
                                   ^
ERROR!
Main.java:62: error: illegal start of expression
                e.add(new Ele(r,c,(|r-rCenter|+|c-cCenter|)));
                                               ^
Main.java:62: error: illegal start of expression
                e.add(new Ele(r,c,(|r-rCenter|+|c-cCenter|)));
                                                          ^
3 errors

=== Code Exited With Errors ===

Start small. Ship something.
[0,0,-1] //doubt
[0,1,0]
[1,0,0]
[1,1,1]
00
00

=== Code Execution Successful ===

Start small. Ship something.
[Ele@15db9742, Ele@6d06d69c]
00

=== Code Execution Successful ===
*/

