//Question: https://leetcode.com/problems/valid-palindrome/description/

/* 
125. Valid Palindrome

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 
Constraints:
1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
*/

/* 
Steps:
1. Start.
2. Create 2 new var of type StringBuilder sb and rsb.
3. Create a array char[] c and set it to char[] c = s.toCharArray.
4. Create a new var of type boolean out and set it to out = false.
5. Create a new var of type int n and set it to n = c.length-1.
6. Create a new var of type String specialChars and set it to specialChars = " !@#$%^&*()-_=+[]{};:'\",.<>/?\\|`~";.
7. Create a new var of type int j and set it to j = n.
8. For int i=0 to i<c.length (increament i++)
9. Check if c[i] does not exists in specialChars using specialChars.indexOf(c[i])==-1. 
10. Check if c[i] >= 'A' and c[i]<='Z'.
11. Append (char) (c[i])+32 to sb sb.append((char)(c[i]+32)).
12. Else Append c[i] to sb sb.append(c[i]).
13. Check if c[j] does not exists in specialChars using specialChars.indexOf(c[j])==-1. 
14. Check if c[j] >= 'A' and c[j]<='Z'.
15. Append (char) (c[j])+32 to sb sb.append((char)(c[j]+32)).
16. Else Append c[j] to sb sb.append(c[j]).
17. Decreament j--.
18. Check if sb.toString().equals(rsb.toString()).
19. Set out = true.
20. Return out.
21. Stop.
*/

class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder rsb = new StringBuilder();
        char[] c = s.toCharArray();
        boolean out = false;
        int n = c.length-1;
        String specialChars = " !@#$%^&*()-_=+[]{};:'\",.<>/?\\|`~";
        int j=n;
        for(int i=0; i<n+1; i++) {
            if(specialChars.indexOf(c[i])==-1) { 
                //if char found positive index is returned else return -1.
                if(c[i]>='A' & c[i]<='Z') {
                    sb.append((char)(c[i]+32)); //convert to lowercase.
                } 
                else {
                    sb.append(c[i]);   
                }
            }
            if(specialChars.indexOf(c[j])==-1) {
                if(c[j]>='A' & c[j]<='Z') {
                    rsb.append((char)(c[j]+32)); //convert to lowercase.
                } 
                else {
                    rsb.append(c[j]);   
                }
            }
            j--;
        }
        //System.out.println("sb:"+sb.toString());
        //System.out.println("rsb:"+rsb.toString());
        if(sb.toString().equals(rsb.toString())) {
            out = true;
        } 
        // else {
        //     out = false;
        // }
        return out;
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("Hello world.");
        Solution s = new Solution();
        String in = "A man, a plan, a canal: Panama";
        //String in = "lol";
        System.out.println(s.isPalindrome(in));
    }
}

/* 
Time Complexity:
loop 1 -> to check arrange and build result.
O(n).
*/
/*
Notes:
String specialChars = " !@#$%^&*()-_=+[]{};:'\",.<>/?\\|`~";
specialChars.indexOf(c[i])==-1
- The indexOf() method returns a positive int Index value if c[i] is found in specialChars.
- And Returns '-1' if the c[i] is not present in specialChars.

- Check if c[i] >= 'A' and c[i] <= 'Z' to find if the char is Uppercase.
- Use ((char)(c[i]+32)) -> To convert to a lowercase char.
*/

/*
Logical issues in code.
output:
Hello world.
sb:Amanplancanaanaa
rsb:aanaanacnalpnamA
false

=== Code Execution Successful ===

Hello world.
sb:lol
rsb:lol
true

=== Code Execution Successful ===

to lower case functionality added
Hello world.
sb:amanaplanacanalpanama
rsb:?manaPlanacanalpanamA
false

=== Code Execution Successful ===

Hello world.
sb:amanaplanacanalpanama
rsb:amanaplanacanalpanama
true

=== Code Execution Successful ===
*/