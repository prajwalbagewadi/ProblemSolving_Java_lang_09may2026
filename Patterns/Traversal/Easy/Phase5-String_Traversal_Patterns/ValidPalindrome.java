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

class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder rsb = new StringBuilder();
        char[] c = s.toCharArray();
        boolean out;
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
                if(c[i]>='A' & c[i]<='Z') {
                    rsb.append((char)(c[j]+32)); //convert to lowercase.
                } 
                else {
                    rsb.append(c[j]);   
                }
            }
            j--;
        }
        System.out.println("sb:"+sb.toString());
        System.out.println("rsb:"+rsb.toString());
        if(sb.toString().equals(rsb.toString())) {
            out = true;
        } 
        else {
            out = false;
        }
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
*/