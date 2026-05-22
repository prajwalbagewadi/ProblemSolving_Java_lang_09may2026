//Question: https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/description/

/*
1299. Replace Elements with Greatest Element on Right Side

Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.

After doing so, return the array.

Example 1:
Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]
Explanation: 
- index 0 --> the greatest element to the right of index 0 is index 1 (18).
- index 1 --> the greatest element to the right of index 1 is index 4 (6).
- index 2 --> the greatest element to the right of index 2 is index 4 (6).
- index 3 --> the greatest element to the right of index 3 is index 4 (6).
- index 4 --> the greatest element to the right of index 4 is index 5 (1).
- index 5 --> there are no elements to the right of index 5, so we put -1.

Example 2:
Input: arr = [400]
Output: [-1]
Explanation: There are no elements to the right of index 0.
 
Constraints:
1 <= arr.length <= 104
1 <= arr[i] <= 105
*/

class Solution {
    public int[] replaceElements(int[] arr) {
        int[] out = new arr.length;
        int k = 0,max=arr[1];
        for(int i=k+1; i<arr.length; i++) {
           if(arr[i]>max) {
            max=arr[i];
           }
           k++;
        }
    }
}

class Main {
    public static void main(String[] args) {
        Solution s = new Solution;
        int[] arr = {17,18,5,4,6,1};
        for(int i : s.replaceElements(arr)) {
            System.out.print(" "+i);
        }
    }
}

/*
notes:
class Solution {
    public int[] replaceElements(int[] arr) {
        int[] out = new int[arr.length];
        int k = 0;
        while(k<arr.length) {
            int max=arr[k+1];
            for(int i=k+1; i<arr.length; i++) {
                for(int j=k+1; j<arr.length; j++) {
                   System.out.print(" "+arr[j]);
                }
                System.out.println();
                if(arr[i]>max) {
                    max=arr[i];
                }
            }    
            out[k] = max;
            System.out.println("out[k]="+out[k]);
            k++;
            System.out.println("k="+k);
        }
        return out;    
        
    }
}
*/
/*
output:
 18 5 4 6 1
 18 5 4 6 1
 18 5 4 6 1
 18 5 4 6 1
 18 5 4 6 1
out[k]=18
k=1
 5 4 6 1
 5 4 6 1
 5 4 6 1
 5 4 6 1
out[k]=6
k=2
 4 6 1
 4 6 1
 4 6 1
out[k]=6
k=3
 6 1
 6 1
out[k]=6
k=4
 1
out[k]=1
k=5
ERROR!
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 6 out of bounds for length 6
	at Solution.replaceElements(Main.java:36)
	at Main.main(Main.java:60)

=== Code Exited With Errors ===
*/

/*
Dry Run:
[17,18,5,4,6,1]
k=0 K=1 to length

*/
