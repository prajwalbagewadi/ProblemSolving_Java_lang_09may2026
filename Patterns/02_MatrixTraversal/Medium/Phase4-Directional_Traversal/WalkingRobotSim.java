// Question: https://leetcode.com/problems/walking-robot-simulation/

/*
874. Walking Robot Simulation

A robot on an infinite XY-plane starts at point (0, 0) facing north. The robot receives an array of integers commands, which represents a sequence of moves that it needs to execute. There are only three possible types of instructions the robot can receive:

-2: Turn left 90 degrees.
-1: Turn right 90 degrees.
1 <= k <= 9: Move forward k units, one unit at a time.

Some of the grid squares are obstacles. The ith obstacle is at grid point obstacles[i] = (xi, yi). If the robot runs into an obstacle, it will stay in its current location (on the block adjacent to the obstacle) and move onto the next command.

Return the maximum squared Euclidean distance that the robot reaches at any point in its path (i.e. if the distance is 5, return 25).

Note:
There can be an obstacle at (0, 0). If this happens, the robot will ignore the obstacle until it has moved off the origin. However, it will be unable to return to (0, 0) due to the obstacle.
North means +Y direction.
East means +X direction.
South means -Y direction.
West means -X direction.
 
Example 1:
Input: commands = [4,-1,3], obstacles = []
Output: 25
Explanation:
The robot starts at (0, 0):
Move north 4 units to (0, 4).
Turn right.
Move east 3 units to (3, 4).
The furthest point the robot ever gets from the origin is (3, 4), which squared is 32 + 42 = 25 units away.

Example 2:
Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
Output: 65
Explanation:
The robot starts at (0, 0):
Move north 4 units to (0, 4).
Turn right.
Move east 1 unit and get blocked by the obstacle at (2, 4), robot is at (1, 4).
Turn left.
Move north 4 units to (1, 8).
The furthest point the robot ever gets from the origin is (1, 8), which squared is 12 + 82 = 65 units away.

Example 3:
Input: commands = [6,-1,-1,6], obstacles = [[0,0]]
Output: 36
Explanation:
The robot starts at (0, 0):
Move north 6 units to (0, 6).
Turn right.
Turn right.
Move south 5 units and get blocked by the obstacle at (0,0), robot is at (0, 1).
The furthest point the robot ever gets from the origin is (0, 6), which squared is 62 = 36 units away.

Constraints:
1 <= commands.length <= 104
commands[i] is either -2, -1, or an integer in the range [1, 9].
0 <= obstacles.length <= 104
-3 * 104 <= xi, yi <= 3 * 104
The answer is guaranteed to be less than 231.
*/

/*
Algo:
1. Start.
2. Create int vars x and y and set x=0 and y=0.
3. Create array int[] pos and set it (0,0).
4. Create a int var direction to store direction (0=North, 1=East, 2=South, 3=West). 
5. Get the first command from the commands[] array.
6. For int i=0 to i<commands.length (increament i++).
7. Check if the commands[i] == -1 or == -2.
8. Else 
9. switch (direction)

7. Check Turn and calculate the direction 
8. Else proceed towards the point.
*/

import java.lang.Math;
 
/*
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int eDist=0;
        int x=0;
        int y=0;
        int direction=0; //0=North, 1=East, 2=South, 3=West
        for(int i=0; i<commands.length; i++) {
            if(commands[i]==-1 || commands[i]==-2) {
                if(direction<=3) {
                    if(commands[i]==-1) {
                        //Right Turn
                        Math.abs(direction++);
                    }
                    if(commands[i]==-2) {
                        //Left Turn
                        Math.abs(direction--);
                    }
                }
                System.out.println("direction:"+direction);
            }
            else {
                if(x==obstacles[0][0] || y==obstacles[0][1]) {
                    if(x==obstacles[0][0]) {
                        x=x--;
                    }
                    if(y==obstacles[0][1]) {
                        y=y--;
                    }
                    System.out.println(obstacles[0][0]+","+obstacles[0][1]+"obstacle detected.");
                    System.out.println("x="+x+" "+"y="+y);
                }
                switch(direction) {
                    case 0: { 
                        //North
                        y=commands[i];
                        System.out.println("y="+y);
                    }
                    break;
                    case 1: {
                        //East
                        x=commands[i];
                        System.out.println("x="+x);
                    }
                    break;
                    case 2: {
                        //South
                        y=-commands[i];
                        System.out.println("y="+y);
                    }
                    break;
                    case 3: {
                        //West
                        x=-commands[i];
                        System.out.println("x="+x);
                    }
                    break;
                    default: {
                        System.out.println("Error in direction.");
                    }
                }
            }
        }
        System.out.println("x="+x);
        System.out.println("y="+y);
        eDist = (x*x) + (y*y);
        return eDist;
    }
}
*/

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int eDist=0;
        int x=0;
        int y=0;
        int direction=0; //0=North, 1=East, 2=South, 3=West
        int steps=0;
        int s;
        int i=0;
        while(i<commands.length) {
            // check if command is a turn. Execute and set direction.
            if(commands[i]==-1 || commands[i]==-2) {
                if(direction<=3) {
                    if(commands[i]==-1) {
                        //Right Turn
                        direction=Math.abs(direction++);
                    }
                    if(commands[i]==-2) {
                        //Left Turn
                        direction=Math.abs(direction--);
                    }
                }
            }
            // forward command.
            else {
                steps=commands[i];
                switch(direction) {
                    case 0: {
                        //North
                        s=y;
                        while(s<commands[i]) {
                            if(y==obstacles[0][1]) {
                                y--;
                                break;
                            }
                            s++;
                            y=s;
                        }
                    }
                    break;
                    case 1: {
                        //East
                        s=x;
                        while(s<commands[i]) {
                            if(x==obstacles[0][0]) { 
                                x--;
                                break;
                            }
                            s++;
                            x=s;
                        }
                    }
                    break;
                    case 2: {
                        //South
                        s=y;
                        while(s<commands[i]) {
                            if(y==obstacles[0][1]) { 
                                y--;
                                break;
                            }
                            s++;
                            y=-s;
                        }
                    }
                    break;
                    case 3: {
                        //East
                        s=x;
                        while(s<commands[i]) {
                            if(x==obstacles[0][0]) {
                                x--;
                                break;
                            }
                            s++;
                            x=-s;
                        }
                    }
                    break;
                    default: {
                        System.out.println("Error in direction.");
                    }
                }
            }
            i++;
        }
        System.out.println("x="+x);
        System.out.println("y="+y);
        eDist = (x*x) + (y*y);
        return eDist;
    }
}


class Main {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
        Solution s = new Solution();
        //int[] cmd = {4,-1,3};
        int[] cmd = {4,-1,4,-2,4};
        int[][] obs = {{2,4}};
        System.out.println(s.robotSim(cmd,obs));
    }
}

/*
Output:

//x issue
Start small. Ship something.
x=0
y=4
16

=== Code Execution Successful ===

//observed that x fails to update.
Start small. Ship something.
y=4
direction:1
2,4obstacle detected.
x=0 y=4
x=4
direction:0
2,4obstacle detected.
x=4 y=4
y=4
x=4
y=4
32

=== Code Execution Successful ===

ERROR!
Main.java:112: error: illegal start of expression
                   while(commands[t]!==-1 || commands[t]==-2) {
                                      ^
1 error

=== Code Exited With Errors ===

Start small. Ship something.
direction:1
x=3
y=4
25

=== Code Execution Successful ===

Start small. Ship something.
direction:0
x=0
y=3
9

=== Code Execution Successful ===

*/

/*
Notes:

TURN:
-1: Turn right 90.
-2: Turn left 90.

Obstacle:
If obstacle is Encountered.
- Stop the current Forward command.
- Search for the Next Turn command.
- Proceed with the Next Forward command.

Directions:
- North: 
1. No TURNS initial position.
2. forward command increases Y(+Y).

- East: 
1. ONE Right turn.
2. Command -1.
3. forward command increases X(+X).

- South: 
1. Two Left turns or Two Right turns.
2. commands(-2,-2) or (-1,-1) 
3. forward command decreases Y(-Y).
    - Eg:  commands (-1,-1,3)
    - (0,0) NORTH initial pos.
    - (-1) Turn Right 90. EAST.
    - (-1) Turn Right 90. SOUTH.
    - (0,-1) SOUTH.
    - (0,-2) SOUTH.
    - (0,-3) SOUTH. Final pos (0,-3) SOUTH.

- West:
1. ONE left Turn or Three Right Turns.
2. commands (-2) or (-1,-1,-1) 
3. forward command decreases X(-X).
    - Eg: commands (-2,2)
    - (0,0) NORTH initial pos.
    - (-2) Turn Left 90. WEST.
    - (-1,0) WEST.
    - (-2,0) WEST. Final pos (-2,0) WEST.

TestRun:
Commands = 4,-1,3
    - Initial Pos 0,0 north.
    - 1st command (4)
        - (0,1) NORTH.
        - (0,2) NORTH.
        - (0,3) NORTH.
        - (0,4) NORTH.
    - 2nd command (-1) 
        - (0,4) Turn Right 90 EAST.
    - 3rd command (3)
        - (1,4)
        - (2,4)
        - (3,4) Final pos (3,4) EAST.
*/
