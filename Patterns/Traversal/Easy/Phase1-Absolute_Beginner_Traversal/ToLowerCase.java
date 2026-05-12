//Question: https://leetcode.com/problems/to-lower-case/description/

/*
709. To Lower Case

Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.

Example 1:
Input: s = "Hello"
Output: "hello"

Example 2:
Input: s = "here"
Output: "here"

Example 3:
Input: s = "LOVELY"
Output: "lovely"
 
Constraints:
1 <= s.length <= 100
s consists of printable ASCII characters.
*/

/*
Steps:
1. Start.
2. Take String input s.
3. Create new StringBuilder variable sb.
4. For each char c in String s using s.toCharArray().  
5. If c is >= 'A' and c <= 'Z'.
6. Type cast (char) c+32 and append it to sb.
7. else directly append c to sb.
8. Convert sb to String and return.
9. Stop.
*/

class Solution3 {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(c >= 'A' && c <= 'Z') {
                sb.append((char)(c+32));
            }
            else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

public class ToLowerCase {
    public static void main(String[] args) {
        String s = "Hello";
        Solution3 sol = new Solution3();
        System.out.println(sol.toLowerCase(s));
    }
}

//notes:
/*
Because in the ASCII table, uppercase and lowercase English letters are stored with a fixed gap of 32.
Example:
A = 65
a = 97
Difference:
Same for:
H = 72
h = 104
So computers were designed so that:
adding 32 converts uppercase → lowercase
subtracting 32 converts lowercase → u
*/
