/* 
412. Fizz Buzz

Given an integer n, return a string array answer (1-indexed) where:

answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
answer[i] == "Fizz" if i is divisible by 3.
answer[i] == "Buzz" if i is divisible by 5.
answer[i] == i (as a string) if none of the above conditions are true.
 
Example 1:
Input: n = 3
Output: ["1","2","Fizz"]

Example 2:
Input: n = 5
Output: ["1","2","Fizz","4","Buzz"]

Example 3:
Input: n = 15
Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 
Constraints:
1 <= n <= 104
*/

/* 
Steps:
1. Start.
2. Take input n.
3. Create a List.
4. For i=1 to n.
5. If i%3 == 0 && i%5 == 0.
6. Add "FizzBuzz" to List.
7. Else if i%5 == 0.
8. Add "Buzz" to List.
9. Else if i%3 == 0.
10. Add "Fizz" to List.
11. Else convert i to String and add to List.
12. Return List<String> out.
13. Stop. 
*/


package Traversal;

// i % 3 or i % 5  or both should return remainder 0
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> out = new ArrayList<String>();
        for(int i=1; i<=n; i++) {
            if(i%3 == 0 && i%5 == 0){
                out.add("FizzBuzz");
            } else if (i%5 == 0) {
                out.add("Buzz");
            } else if (i%3 == 0) {
                out.add("Fizz");
            } else {
                out.add(Integer.toString(i));
            }
        }
        return out;
    }
}

public class FizzBuzz {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
        Solution s = new Solution();
        System.out.println(s.fizzBuzz(5));
    }
}
