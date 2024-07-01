package basicQuestions;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Given an array of integers 'a', move all the even integers at the beginning of the array followed by all the odd integers does not matter, Return any array that satisfies the condition.
 */
class OddEvenSep {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an array separated by spaces: ");
        String str = sc.nextLine();
        String[] strArr = str.split(" ");
        int[] arr = new int[strArr.length];
        for(int i =0; i < strArr.length;i++){
            arr[i] = Integer.parseInt(strArr[i].trim());
        }

        System.out.println("the seperated array: ");
        System.out.println(Arrays.toString(oddEvenSeparation(arr)));

    }

    public static int[] oddEvenSeparation(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // Increment left index while we see an even number at the left
            while (left < right && arr[left] % 2 == 0) {
                left++;
            }
            // Decrement right index while we see an odd number at the right
            while (left < right && arr[right] % 2 != 0) {
                right--;
            }
            // If there is a misplacement, swap the elements
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        return arr;
    }
}
