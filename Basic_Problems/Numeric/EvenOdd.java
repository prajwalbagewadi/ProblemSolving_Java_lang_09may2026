//Even odd code

/*
- Even numbers are divisible by 2
- Odd numbers leave remainder 1, when divided by % 2.

Steps:
- start
- Take input n
- Take variable i -> Start from 0 to n
- check divisibility of i % 2.
- if remainder 0 -> even
- else -> odd
- stop
*/

import java.util.Scanner;

class EvenOdd {
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        int n = sc.nextInt();
        int i = 0;
        
        while(i<=n){
            if(i%2 == 0){
                System.out.println(i+" - Even.");
            }
            else {
                System.out.println(i+" - Odd.");
            }
            i++;
        }
    }
}
