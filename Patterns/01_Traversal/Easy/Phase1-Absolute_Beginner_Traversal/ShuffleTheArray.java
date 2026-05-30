//Question: https://leetcode.com/problems/shuffle-the-array/description/

/* 
1470. Shuffle the Array

Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].

Return the array in the form [x1,y1,x2,y2,...,xn,yn].

Example 1:
Input: nums = [2,5,1,3,4,7], n = 3
Output: [2,3,5,4,1,7] 
Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].

Example 2:
Input: nums = [1,2,3,4,4,3,2,1], n = 4
Output: [1,4,2,3,3,2,4,1]

Example 3:
Input: nums = [1,1,2,2], n = 2
Output: [1,2,1,2]
 
Constraints:
1 <= n <= 500
nums.length == 2n
1 <= nums[i] <= 10^3

concepts:
- Alternate Traversal
*/

/* 
Steps:
1. Start.
2. Take input nums[] and n = nums.length/2
3. Create res[] of size 2*n.
4. Create a var k=0 for keeping track of output res[] indexes
5. For i=0 to n.
6. Set res[k] = nums[i], for first half.
7. Increament k++.
8. Set res[k] = nums[i+n], for second half.
9. Increament k++.
10. Return res[].
11. Stop. 
*/
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2*n];
        int k = 0;
        for(int i=0; i<n; i++){
            res[k] = nums[i]; //first half
            k++;
            res[k] = nums[i+n]; //second half
            k++;
        }
        return res;
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
        
        int[] arr = {2,5,1,3,4,7};
        int n = arr.length/2;
        Solution s = new Solution();
        int[] out = s.shuffle(arr,n);
        for(int i : out){
            System.out.println(" "+i);
        }
        
    }
}

// rough notes.

// 0 1 2  3 4 5
// 2 5 1  3 4 7

// 0  3  1  4  2  5
// 2 (3) 5 (4) 1 (7)

// even odd even odd even odd
//  0    3   1   4    2    5
 
//  0 + 3 = 3
//  1 + 3 = 4
//  2 + 3 = 5

// if(i == 0 || i <= 2*n-2) {
//     res[i] = nums[i];
// } 
// else {
//     res[i] = nums[i-1+n];
//}
           
// res[0] = nums[0]         0
// res[1] = nums[1-1+3]     3
// res[2] = nums[2-1]       1
// res[3] = nums[3-1+3-1]   4
// res[4] = nums[4-(1+1)]     2 
// res[5] = nums[5]         5

// Chatgpt what pattern do see in this (0,3,1,4,2,5)
// alternating between two halves of the arr
// 0 from first half 
// 3 from second half n+1-i = 3+1-1 = 4-1 = 3
// 1 from first half i-1 = 2-1 = 1
// 4 from second half n+1-i = 4-3 = 2

// int n = 3;
// for(int i=0; i<3; i++) {
//     System.out.println("i="+i);
//     System.out.println("n+i="+(n+i));
// }

// i=0   res[0]
// n+i=3 res[0+1] = 1
// i=1   res[1]
// n+i=4 res[1+1] = 2
// i=2
// n+i=5

// Use a normal var k=0 and increament it after first half and second half to keep track of res[k].