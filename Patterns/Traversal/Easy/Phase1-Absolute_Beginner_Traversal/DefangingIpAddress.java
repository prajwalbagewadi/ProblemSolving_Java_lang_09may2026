//Question: https://leetcode.com/problems/defanging-an-ip-address/description/

/* 
1108. Defanging an IP Address

Given a valid (IPv4) IP address, return a defanged version of that IP address.

A defanged IP address replaces every period "." with "[.]".

Example 1:
Input: address = "1.1.1.1"
Output: "1[.]1[.]1[.]1"

Example 2:
Input: address = "255.100.50.0"
Output: "255[.]100[.]50[.]0"
 
Constraints:
The given address is a valid IPv4 address.
*/

/*
Steps:
1. Start.
2. Take input Ip address as String.
3. Create StringBuilder variable sb.
4. For each char c in String address using address.toCharArray().
5. If char c == '.' period.
6. Append the String "[.]" to sb.
7. Else directly append the char c to sb.
8. Convert sb.toString() and return.
9. Stop.
*/
class Solution4 {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for(char c : address.toCharArray()) {
            if(c == '.') {
                sb.append("[.]");
            }
            else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

public class DefangingIpAddress {
    public static void main(String[] args) {
        Solution4 sol = new Solution4();
        String address = "255.100.50.0";
        System.out.println(sol.defangIPaddr(address));
    }
}