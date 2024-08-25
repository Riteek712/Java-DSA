package basicQuestions;

import java.util.Scanner;

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
