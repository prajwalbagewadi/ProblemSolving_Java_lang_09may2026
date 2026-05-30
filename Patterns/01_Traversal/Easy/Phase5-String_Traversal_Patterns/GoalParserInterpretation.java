//Question: https://leetcode.com/problems/goal-parser-interpretation/description/

/*
1678. Goal Parser Interpretation

You own a Goal Parser that can interpret a string command. The command consists of an alphabet of "G", "()" and/or "(al)" in some order. The Goal Parser will interpret "G" as the string "G", "()" as the string "o", and "(al)" as the string "al". The interpreted strings are then concatenated in the original order.

Given the string command, return the Goal Parser's interpretation of command.

Example 1:
Input: command = "G()(al)"
Output: "Goal"
Explanation: The Goal Parser interprets the command as follows:
G -> G
() -> o
(al) -> al
The final concatenated result is "Goal".

Example 2:
Input: command = "G()()()()(al)"
Output: "Gooooal"

Example 3:
Input: command = "(al)G(al)()()G"
Output: "alGalooG"
 
Constraints:
1 <= command.length <= 100
command consists of "G", "()", and/or "(al)" in some order.
*/

/*
Steps:
1. Start.
2. Take String input command.
3. Create new var of type StringBuilder sb.
4. Create new Char array char[] cmd and set it to command.toCharArray().
5. For int i=0 to i < cmd.length (increament i++).
6. Check if cmd[i] == 'G'.
7. Append 'G' to sb.append('G').
8. Check else if cmd[i] == '(' and i < cmd.length-1.
9. Check if cmd[i+1] == ')'.
10. Append 'o' to sb.append('o').
11. Else Append "al" to sb.append("al").
12. Convert sb.toString().
13. Return sb.
14. Stop.
*/

class Solution {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        char[] cmd = command.toCharArray();
        for(int i=0; i<cmd.length; i++) {
            if(cmd[i]=='G') {
                sb.append('G');
            }
            else if(cmd[i]=='(' && i<cmd.length-1) {
                if(cmd[i+1]==')') {
                    sb.append('o');
                }
                else {
                    sb.append("al");
                }
            }
        }
        return sb.toString();
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("hello world.");
        Solution s = new Solution();
        //String cmd = "G()()()()(al)";
        //String cmd = "G()(al)";
        String cmd = "(al)G(al)()()G";
        System.out.println(s.interpret(cmd));
    }
}

/*
Time Complexity:
loop 1 -> check the chars and build result.
O(n).
*/

/*
output:
hello world.
alGalooG
*/