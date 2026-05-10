/*
1929. Concatenation of Array

Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).

Specifically, ans is the concatenation of two nums arrays.

Return the array ans.

Example 1:
Input: nums = [1,2,1]
Output: [1,2,1,1,2,1]
Explanation: The array ans is formed as follows:
- ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
- ans = [1,2,1,1,2,1]

Example 2:
Input: nums = [1,3,2,1]
Output: [1,3,2,1,1,3,2,1]
Explanation: The array ans is formed as follows:
- ans = [nums[0],nums[1],nums[2],nums[3],nums[0],nums[1],nums[2],nums[3]]
- ans = [1,3,2,1,1,3,2,1]
 
Constraints:
n == nums.length
1 <= n <= 1000
1 <= nums[i] <= 1000
*/

/*
Steps:
1. Start.
2. Take input nums[].
3. Store nums.length() in n.
4. Create res[] of size 2*n.
5. For i=0 to 2*n.
6. If i < n. 
7. Add res[i] = nums[i]; 
8. Else res[i] = nums[i-n];
9. Return res[].
10. Stop.
*/

package Traversal;

class Solution1 {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] res = new int[2*n];
        for(int i=0; i < 2*n; i++){
            if(i<n) {
                res[i] = nums[i];
            } else {
                res[i] = nums[i-n];
            }
        }
        return res;
    }
}

public class ConcatenationOfArray {

    public static void main(String[] args) {
        int[] nums = {1,2,1};
        Solution1 sol = new Solution1();
        int[] out = sol.getConcatenation(nums);
        for(int i : out){
            System.out.print(" "+ i);
        }
    }
}
