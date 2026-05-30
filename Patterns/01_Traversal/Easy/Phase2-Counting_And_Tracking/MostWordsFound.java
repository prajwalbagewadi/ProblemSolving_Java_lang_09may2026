//Question:https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/

/*
2114. Maximum Number of Words Found in Sentences
A sentence is a list of words that are separated by a single space with no leading or trailing spaces.

You are given an array of strings sentences, where each sentences[i] represents a single sentence.

Return the maximum number of words that appear in a single sentence.
Example 1:
Input: sentences = ["alice and bob love leetcode", "i think so too", "this is great thanks very much"]
Output: 6
Explanation: 
- The first sentence, "alice and bob love leetcode", has 5 words in total.
- The second sentence, "i think so too", has 4 words in total.
- The third sentence, "this is great thanks very much", has 6 words in total.
Thus, the maximum number of words in a single sentence comes from the third sentence, which has 6 words.

Example 2:
Input: sentences = ["please wait", "continue to fight", "continue to win"]
Output: 3
Explanation: It is possible that multiple sentences contain the same number of words. 
In this example, the second and third sentences (underlined) have the same number of words.
 
Constraints:
1 <= sentences.length <= 100
1 <= sentences[i].length <= 100
sentences[i] consists only of lowercase English letters and ' ' only.
sentences[i] does not have leading or trailing spaces.
All the words in sentences[i] are separated by a single space.
*/

/*
steps:
1. Start.
2. Take input String[] sentences.
3. Create int variable and set i=0.
4. Create int variable and set max=0.
5. For String s in sentences.
6. Create int variable and set count=1.
7. For char c in s.toCharArray().
8. Check if c == ' ' (space).
9. Increament count++.
10. Check if count > max.
11. Set max = count.
12. Increament i++.
13. Return max.
14. Stop.
*/

class Solution {
    public int mostWordsFound(String[] sentences) {
        int i = 0;
        int max = 0;
        
        for(String s: sentences){
            int count = 1;
            for(char c : s.toCharArray()) {
                if(c == ' ') {
                    count++;
                }
            }
           //System.out.println(count);
            if(count > max) {
                max = count;
            }
            i++;
        }    
        return max;    
    }
}

class Main {
    public static void main(String[] args) {
       // String[] sen = {"alice and bob love leetcode","i think so too","this is great thanks very much"};
      String[] sen = {"please wait", "continue to fight", "continue to win"};
        Solution s = new Solution();
        System.out.println("mostWordsFound:"+s.mostWordsFound(sen));
    }
}

/*
Output:
2
3
3
mostWordsFound:3

=== Code Execution Successful ===
*/

/*
Notes:
Because in a normal sentence. Words are separated by spaces.

So:
1 space = 2 words
2 spaces = 3 words
3 spaces = 4 words

Hence: spaces+1;
*/
