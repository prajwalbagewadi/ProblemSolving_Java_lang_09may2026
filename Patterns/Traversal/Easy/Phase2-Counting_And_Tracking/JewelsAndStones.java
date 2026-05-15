//Question: https://leetcode.com/problems/jewels-and-stones/description/

/* 
771. Jewels and Stones

You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.

Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:
Input: jewels = "aA", stones = "aAAbbbb"
Output: 3

Example 2:
Input: jewels = "z", stones = "ZZ"
Output: 0
 
Constraints:
1 <= jewels.length, stones.length <= 50
jewels and stones consist of only English letters.
All the characters of jewels are unique.
*/

/*
Steps:
1. Start
2. Take String input jewels, stones.
3. Convert jewels toCharArray() and Store in a new char[ ] j.
4. Create int[ ] sfreq to store frequency of characters and allocate size int[256] as ascii characters range from 0 to 255.
5. Create a int var count = 0.
6. For char c in stones.toCharArray()
7. At sfreq[c] = increment the count from 0 to count++, the char c is automatically converted to its int value, which is used as the array index. And then the count is increamented.
8. For char c in array j.
9. Add count = count + value at index sfreq[c].
10. Return count.
11. Stop.
*/

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        char[] j = jewels.toCharArray();
        int[] sfreq = new int[256];
        int count = 0;
        
        for(char c : stones.toCharArray()) {
            sfreq[c]++;
        }
        for(char c : j) {
            count = count + sfreq[c];
        }
        return count;
    }
}


class JewelsAndStones {
    public static void main(String[] args) {
       Solution sol = new Solution();
       //String jewels = "aA";
       //String stones = "aAAbbbb";
       String jewels = "z";
       String stones = "ZZ";
       System.out.println(sol.numJewelsInStones(jewels, stones));
    }
}

/*
Output:
3
*/

/*
Output:
0
*/

//Notes

//Array hashing:
 

/* 
int[] freq = new int[256]
- Why freq size 256, because basic ASCII characters range from 0 to 255

Visual:
Index Character
65    A
97    a
98    b

Hashing with frequency count:
- Store how many times each element appears.
- Instead of searching again and again, you keep counts in hash structure.

Eg:
String s = "banana"
count freq:
b -> 1
a -> 3
n -> 2

Example:
public class Main {
    public static void main(String[] args) {
        int val = 'a'; //Storing char into int var gives the chars ascii val.
        System.out.println("Ascii val of 'a':"+val);

        String s = "Support";
        int[] freq = new int[256];

        for(char c : s.toCharArray()) {
            freq[c]++;
        }
        System.out.println("Freq count:");

        System.out.println("'s':"+freq['s']);
        System.out.println("'S':"+freq['S']);
        System.out.println("'u':"+freq['u']);
        System.out.println("'p':"+freq['p']);
        System.out.println("'o':"+freq['o']);
        System.out.println("'r':"+freq['r']);
        System.out.println("'t':"+freq['t']);
    }
}

/*
D:\Software_Installed\jdk\bin\java.exe "-javaagent:D:\Software_Installed\IntellJInstall\IntelliJ IDEA Community Edition 2025.2\lib\idea_rt.jar=59368" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath C:\Users\bagew\Desktop\Project_Ideas\problemSolving_java\problemSolving\out\production\problemSolving Main
Ascii val of 'a':97
Freq count:
's':0
'S':1
'u':1
'p':2
'o':1
'r':1
't':1

Process finished with exit code 0
*/
