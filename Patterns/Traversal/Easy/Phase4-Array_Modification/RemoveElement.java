//Question: https://leetcode.com/problems/remove-element/

/*
27. Remove Element

Given an integer numsay nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

Change the numsay nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
Return k.
Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input numsay
int val = ...; // Value to remove
int[] expectedNums = [...]; // The expected answer with correct length.
                            // It is sorted with no values equaling val.

int k = removeElement(nums, val); // Calls your implementation

assert k == expectedNums.length;
sort(nums, 0, k); // Sort the first k elements of nums
for (int i = 0; i < actualLength; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.

Example 1:
Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).

Example 2:
Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
Note that the five elements can be returned in any order.
It does not matter what you leave beyond the returned k (hence they are underscores).
 
Constraints:
0 <= nums.length <= 100
0 <= nums[i] <= 50
0 <= val <= 100
*/

/*
Steps:
1. Start.
2. Take input array int[] nums and int val.
3. Create a new var int k and set it to k=0.
4. For i=0 to nums.length.
5. Check if nums[i] != val.
6. Set nums[i] = nums[i] + nums[k]. //swap
7. Set nums[k] = nums[i] - nums[k].
8. Set nums[i] = nums[i] - nums[k].
9. Increament k++.
10. Return k.
11. Stop.
*/

class Solution {
    public int removeElement(int[] nums, int val) {
        int k=0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]!=val) {
                nums[i] = nums[i] + nums[k];
                nums[k] = nums[i] - nums[k];
                nums[i] = nums[i] - nums[k];
                k++; // k updates If condition is satisfied.
            }
        }
        for(int i : nums) {
            System.out.print(" "+i);
        }
        return k;
    }
}

class Main {
    public static void main(String[] args) {
        //int[] nums = {3,2,2,3};
        //int val = 3;
        //int[] nums = {0,1,2,2,3,0,4,2};
        //int val = 2;
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        Solution s = new Solution();
        System.out.println(s.removeElement(nums,val));
    }
}

/*
Output:
5

=== Code Execution Successful ===
*/

/*
Notes:
inPlace: modify the Array without using extra space
eg:
[1,2,3] to [2,4,6]
multiple each element in array by 2.

Two Pointer: used Two Pointer approach to solve
[0,1,2,2,3]
i = 0
k = 0 - swap condition satisfied k++
i = 1
k = 1 - swap condition satisfied k++
i = 2 
k = 1
i = 3
k = 1
i = 4 swap with i = 4 with k = 1.
k = 2 condition satisfied k++
*/

/*
Test case failed:
[0,1,2,2,3,0,4,2]
val = 2
Expected:
[0,1,4,0,3]
*/



