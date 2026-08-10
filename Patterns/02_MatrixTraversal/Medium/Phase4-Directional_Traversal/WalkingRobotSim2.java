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
issues:

Read a article regarding https://www.himanshu-saini.com/dsa/walking-robot-simulation
article talks about constant obstacle checking time using hashset


Iteration 1 (s = 1)
Check next square (0,2) → obstacle found.
flag = true.
y is not updated.

1. You're still overwriting flag
Suppose:
obstacles = [(0,2), (0,5)]
Trying to move to (0,2).
First obstacle → matches → flag = true
Second obstacle → doesn't match → your code does flag = false
So at the end, flag is false, even though the robot should be blocked.
Once you find one blocking obstacle, should a later obstacle be allowed to change the answer?
The answer is no.

You're still making the same logical mistake. Instead of looking at the code, think about this scenario.
Suppose:
Robot is at (0, 0)
Obstacles are:
(5, 5)
(0, 2)
Command = 3
The robot wants to move to (0,1), (0,2), (0,3).
Now, on the first obstacle (5,5):
x == 5 is false.
Your else executes.
You do y = s.
Have you checked the second obstacle (0,2) yet?
No.
So you've already moved before checking all obstacles.
*/

/*
Algo3:
1. Create 3 vars direction, x, y.
2. For loop for iterating through each command(n)
3. Check if command is -1 or -2.
4. else:
5. Switch (direction):
6. Case 0: //move north
7. Calculate Steps = y+commands[i]
8. For s=y; s<=Steps; s++
9. Check if(hashcode(x+(s+1)==hashcode(obstacles(i))
10. Stop and move to next command.
11. else: y=s.
12. Break. 
*/
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        
        int edist = 0;
        int x = 0;
        int y = 0;
        int direction = 0; //north
        int steps;
        boolean flag = false;
        for(int c=0; c<commands.length; c++) {
            if(commands[c]==-1) {
                //right turn 90.
                if(direction==3) {
                    //reset to 0 if direction is 3
                    //270 deg
                    direction = 0;
                    //set zero and exit.
                }
                else {
                    direction++;
                }
            }
            else if(commands[c]==-2) {
                //left Turn 90.
                if(direction==-3) {
                    //reset to 0 if direction is -3
                    //270 deg
                    direction = 0;
                    //set zero and exit.
                }
                else {
                    direction--;
                }
            }
            else {
                switch(direction) {
                    //north
                    case 0: {
                        steps = y + commands[c];
                        flag = false;
                        for(int s=y; s<=steps; s++) {
                            if(s==0) {
                                s=1;
                            }
                            for(int obs=0; obs<obstacles.length; obs++) {
                                if(x==obstacles[obs][0] && s+1==obstacles[obs][1]) {
                                    //stop
                                    flag = true;
                                }
                            }
                            if(flag==false) {
                                y=s;
                            }
                        }
                    }
                    break;
                }
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
        Solution s = new Solution();
        int[] cmd = {4,-1,3};
        int[][] obs = {};
        System.out.println(s.robotSim(cmd,obs));
    }
}
