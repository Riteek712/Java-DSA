package basicQuestions;

import java.util.Scanner;
/*
 Given an array arr[] of length N, the task is to check whether the given array is circularly sorted or not, we need to check whether the given array is the rotated form of the sorted array. 

    - In ascending circularly sorted array, there will be at most one case where the element just before the current element will be greater than the current element i.e., arr[ i – 1 ] > arr[ i ]. If there is no such case, then we consider the array as circularly sorted, this is the result of a rotation by N steps. On the other hand, if there is only one such case; we then make sure that the first element of the array is greater than the last one i.e., arr[0] > arr[N-1].
    - So we need to count the total existence of arr[ i – 1 ] > arr[ i ] cases and if the count is 1 with arr[ 0 ] < arr[ N-1 ] or if the count is greater than 1 then the result will be false else the result will be true meaning that the array is circularly sorted.
 */

public class CircularCheck {
    public static boolean isCircularCheck(int[] arr){

        int checkpoints =0;
        if (arr.length == 1){
            return true;
        }
        for(int i =1; i< arr.length; i++){
            if(arr[i-1]>arr[i]){
                checkpoints++;
            }
        }
        if(checkpoints > 1){
            return false;
        }
        return true;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array sequence with elements seprated by ' ' : ");
        String input = sc.nextLine();
        String[] inputArrStr = input.split(" " );
        int[] arr = new int[inputArrStr.length];
        for(int i =0; i<arr.length;i++){
            arr[i] = Integer.parseInt(inputArrStr[i]);
        }

        System.out.println("Is circularly sorted check: " + isCircularCheck(arr));

    }
}
