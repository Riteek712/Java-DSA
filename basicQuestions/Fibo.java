package basicQuestions;

import java.util.*;
class Fibo{
    public static int fibbo(int n){
        if(n == 1) return 1;
        if(n == 2) return 1;
        return fibbo(n- 1) +fibbo(n -2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter num: ");
        int x = sc.nextInt();
        System.out.println(fibbo(x));
        
    }
}