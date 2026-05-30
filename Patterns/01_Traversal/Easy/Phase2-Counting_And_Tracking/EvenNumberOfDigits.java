//Question: https://leetcode.com/problems/find-numbers-with-even-number-of-digits/description/

/*
1295. Find Numbers with Even Number of Digits

Given an array nums of integers, return how many of them contain an even number of digits.

Example 1:
Input: nums = [12,345,2,6,7896]
Output: 2
Explanation: 
12 contains 2 digits (even number of digits). 
345 contains 3 digits (odd number of digits). 
2 contains 1 digit (odd number of digits). 
6 contains 1 digit (odd number of digits). 
7896 contains 4 digits (even number of digits). 
Therefore only 12 and 7896 contain an even number of digits.

Example 2:
Input: nums = [555,901,482,1771]
Output: 1 
Explanation: 
Only 1771 contains an even number of digits.
 
Constraints:
1 <= nums.length <= 500
1 <= nums[i] <= 105
*/

/*
Steps:
1. Start.
2. Take input int[] nums.
3. Create int var count = 0;
4. For int i in nums[].
5. Create int var digits = 0;
6. While i is not equal to 0.
7. Increament digits++
8. Assign i = i/10 (by removing the last digit)
9. If digits%2 == 0
10. Increament count++.
11. Return count.
*/

class Solution5 {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int i : nums) {
            int digits = 0;
            while(i!=0) {
                //int temp = i%10; //Gets the last digit of a number.
                digits++;
                i = i/10; //Removes the last digit (integer division).
            }
            if(digits%2 == 0) {
                count++;
            }
        }
        return count;
    }
}

class EvenNumberOfDigits {
    public static void main(String[] args) {
        Solution5 s = new Solution5();
        //int[] nums = {555,901,482,1771};
        int[] nums = {12,345,2,6,7896};
        System.out.println(s.findNumbers(nums));
    }
}