//Question: https://leetcode.com/problems/shuffle-the-array/description/

// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2*n];
        for(int i=0; i<2*n; i++) {
           if(i == 0 || i <= 2*n-2) {
               res[i] = nums[i];
           } else {
               res[i] = nums[n+1-i];
           }
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
