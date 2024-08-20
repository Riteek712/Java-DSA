package basicQuestions;

import java.util.Scanner;

public class MinimalString {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the main string: ");
        String s = sc.nextLine();
        System.out.println("Enter to check minimal string: ");
        String b = sc.nextLine();

        System.out.println(checkMinimalString(s, b));


    }

    public static boolean checkMinimalString(String s, String b ){
        if (b.isEmpty() || s.isEmpty()) {
            return false; // Empty strings are not considered minimal
        }

        int l1 = s.length();
        int l2 = b.length();

        if (l1 == l2 ){
            if( s == b)
                return false;
            else
                return true;
        }
        // Iterate through each character in s
        for (int i = 0; i <= l1 - l2; i++) {
            // Check if the current substring of s matches b
            if (s.substring(i, i + l2).equals(b)) {
            return false;  // Found a match, so b is not minimal
            }
        }
        
        // No match found, b is a minimal string
        return true;
    }
}
