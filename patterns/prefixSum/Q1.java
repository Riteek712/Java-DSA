package patterns.prefixSum;

import java.util.Scanner;

/*
 * Given an array of integer of size n. Answer q querries where you need to print the sum of values in given range of indices from 1 to r (both included).
 * NOTE: The value of l and r in queries follows 1 -based indexing.
 */
public class Q1 {

    public static int rangeSum(int[] arr, int l , int r){ // Brute Force
        int sum = 0;
        for(int i = l; i < r; i++){
            sum += arr[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the array seprated by spaces: ");
        String input = sc.nextLine();
        String[] inputArr = input.split(" ");

        int[] intArr = new int[inputArr.length];

        for( int i = 0; i < inputArr.length; i++){
            intArr[i] = Integer.parseInt(inputArr[i]);
        }

        System.out.print("Left:  ");
        int l = sc.nextInt();
        System.out.print("Right:  ");
        int r = sc.nextInt();
        sc.close();

        System.out.println("BRUTE OUTPUT");
        System.out.println(rangeSum(intArr, l, r));

        // Now using prefix sum
        int[] prefixSumArr = new int[inputArr.length +1];
        for(int i = 0; i < prefixSumArr.length; i++){
            if(i==0){
                prefixSumArr[i] = 0;
                continue;
            }
            prefixSumArr[i] = prefixSumArr[i-1] + intArr[i -1];
            
        }

        System.out.printf(prefixSumArr[r] + " - " + prefixSumArr[l] +" = "+(prefixSumArr[r] - prefixSumArr[l]) );
    



    }
}
