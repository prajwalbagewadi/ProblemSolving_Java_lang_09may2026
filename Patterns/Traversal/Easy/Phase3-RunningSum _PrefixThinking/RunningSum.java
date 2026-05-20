//Question: https://leetcode.com/problems/running-sum-of-1d-array/

/*
1480. Running Sum of 1d Array

Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

Return the running sum of nums.

Example 1:
Input: nums = [1,2,3,4]
Output: [1,3,6,10]
Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].

Example 2:
Input: nums = [1,1,1,1,1]
Output: [1,2,3,4,5]
Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].

Example 3:
Input: nums = [3,1,2,10,1]
Output: [3,4,6,16,17]
 
Constraints:
1 <= nums.length <= 1000
-10^6 <= nums[i] <= 10^6
*/

/*
Steps:
1. Start.
2. Take input int[] nums.
3. Create new var sum and set it to nums[0].
4. Create new int[] out of size nums.length.
5. Set out[0] = sum.
6. For i=1 to nums.length.
7. Set sum = (current)sum + nums[i].
8. Set out[i] = sum.
9. Return out.
10. Stop.
*/

class Solution {
    public int[] runningSum(int[] nums) {
        int sum = nums[0];
        int[] out = new int[nums.length];
        out[0] = sum;
        
        for(int i=1; i<nums.length; i++) {
            sum = sum + nums[i];
            out[i] = sum;
        }
        return out;
    }
}

class Main {
    public static void main(String[] args) {
       Solution s = new Solution();
       int[] in = {1,2,3,4};
       int[] out = s.runningSum(in);
       for(int i : out) {
           System.out.printi);
       }
    }
}

/*
Output:
 1 3 6 10
=== Code Execution Successful ===
*/

/*
Time Complexity:
loop 1 -> calculate sum and prepare result 
O(n)
*/


