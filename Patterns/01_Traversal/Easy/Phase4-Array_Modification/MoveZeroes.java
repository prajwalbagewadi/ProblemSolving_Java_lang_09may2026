//Question: https://leetcode.com/problems/move-zeroes/description/

/* 
283. Move Zeroes

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:
Input: nums = [0]
Output: [0]
 
Constraints:
1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 
Follow up: Could you minimize the total number of operations done?
*/

/*
Steps:
1. Start.
2. Take input array int[] nums.
3. Create new int var temp and new var int k and set k to k=0.
4. For int i=0 to nums.length.
5. Check if nums[i] != 0.
6. Set temp = nums[i].
7. Set nums[i] = nums[k].
8. Set nums[k] = temp.
9. Increament k++.
10. Stop. 
*/

class Solution {
    public void moveZeroes(int[] nums) {
        int temp,k=0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]!=0) {
                temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
                k++;
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {0,1,0,3,12};  
        s.moveZeroes(nums);
        for(int i : nums) {
            System.out.print(" "+i);
        }
    }
}

/*
Time Complexity:
loop 1 -> check and swap and increament.
O(n).
*/

/*
output:
 1 3 12 0 0
=== Code Execution Successful ===
*/