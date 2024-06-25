package basicQuestions;

import java.util.*;

public class Armstrong {
    public static int cube(int x){
        return x*x*x;
    }
    public static boolean check(int n){
        // int originalno = n;
        // int count = 0;
        // int temp = n;
        // while (temp != 0)
        // {
        //     count++;
        //     temp = temp / 10;
        // }
        // int sumofpower = 0;
        // while (n != 0)
        // {
        //     int digit = n % 10;
        //     sumofpower += Math.pow(digit,count);
        //     n /= 10;
        // }
        // return (sumofpower == originalno);
        int originalno = n;
        int count = 0;
        int temp = n;
        int count2 =0 ;

        while(temp!=0){
            count++;
            temp = temp /10;
        }
        System.out.println(count);
        temp = originalno;
        while(temp!=0){
            count2 += Math.pow(temp%10,count);
            temp = temp /10;
        }
        if (count2 == originalno) return true;
        return false;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter num: ");
        int x = sc.nextInt();
        System.out.println(check(x));
    }
    
}
