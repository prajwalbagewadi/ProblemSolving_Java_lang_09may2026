//Question: https://leetcode.com/problems/merge-strings-alternately/description/

/*
1768. Merge Strings Alternately

You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.

Return the merged string.

Example 1:
Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r

Example 2:
Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"
Explanation: Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b 
word2:    p   q   r   s
merged: a p b q   r   s

Example 3:
Input: word1 = "abcd", word2 = "pq"
Output: "apbqcd"
Explanation: Notice that as word1 is longer, "cd" is appended to the end.
word1:  a   b   c   d
word2:    p   q 
merged: a p b q c   d
 
Constraints:
1 <= word1.length, word2.length <= 100
word1 and word2 consist of lowercase English letters.
*/

/*
Steps:
1. Start.
2. Take String inputs word1 and word2.
3. Create new StringBuilder sb.
4. Create new int var i set it to i=0.
5. While i < word1.length() + word2.length().
6. Check if i < word1.length().
7. Append word1.charAt(i) to sb.
8. Check if i < word2.length().
9. Append word2.charAt(i) to sb.
10. Increament i++.
11. Convert sb.toString().
12. Return sb.
13. Stop.
*/

class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i<word1.length()+word2.length()) {
            if(i<word1.length()) {
                sb.append(word1.charAt(i));
            }
            if(i<word2.length()) {
                sb.append(word2.charAt(i));
            }
            i++;
        }
        return sb.toString();
    }
}

class MergeStringsAlternately {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
        //String w1 = "abc";
        //String w2 = "pqr";
        //String w1 = "ab";
        //String w2 = "pqrs";
        String w1 = "abcd";
        String w2 = "pq";
        Solution s = new Solution();
        System.out.println(s.mergeAlternately(w1,w2));
    }
}

/*
output:
Start small. Ship something.
apbqcd
*/

/*
Time Complexity:
loop 1 -> loop runs till word1.length + word2.length
O(n+m)
*/
