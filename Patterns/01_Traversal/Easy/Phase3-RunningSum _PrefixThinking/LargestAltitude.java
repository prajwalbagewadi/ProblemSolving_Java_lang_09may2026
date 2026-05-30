//Question: https://leetcode.com/problems/find-the-highest-altitude/

/*
1732. Find the Highest Altitude

There is a biker going on a road trip. The road trip consists of n + 1 points at different altitudes. The biker starts his trip on point 0 with altitude equal 0.

You are given an integer array gain of length n where gain[i] is the net gain in altitude between points i​​​​​​ and i + 1 for all (0 <= i < n). Return the highest altitude of a point.

Example 1:
Input: gain = [-5,1,5,0,-7]
Output: 1
Explanation: The altitudes are [0,-5,-4,1,1,-6]. The highest is 1.

Example 2:
Input: gain = [-4,-3,-2,-1,4,3,2]
Output: 0
Explanation: The altitudes are [0,-4,-7,-9,-10,-6,-3,-1]. The highest is 0.
 
Constraints:
n == gain.length
1 <= n <= 100
-100 <= gain[i] <= 100
*/

/*
Steps:
1. Start.
2. Take input array int[] gain.
3. Create a new int var high set it to high = 0.
4. Create a new int var curr set it to curr = 0.
5. For int i in gain.
6. Set curr = curr + i.
7. Check if curr > high.
8. Set high = curr.
9. Return high.
10. Stop.
*/

class Solution {
    public int largestAltitude(int[] gain) {
        int high = 0;
        int curr = 0;
        for(int i : gain) {
            curr = curr + i;
            if(curr > high) {
                high = curr;
            }
        }
        return high;
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
        //int[] gain = {-5,1,5,0,-7};
        int[] gain = {-4,-3,-2,-1,4,3,2};
        Solution s = new Solution();
        System.out.println(s.largestAltitude(gain));
    }
}

/*
Output:
Start small. Ship something.
0

=== Code Execution Successful ===
*/

/*
Time Complexity:
loop 1 -> check high and build result.
O(n)
*/

