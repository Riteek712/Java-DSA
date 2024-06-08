package sorting;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Selection {
    public static int[] SelectionSort(int[] arr){
        int min, temp = 0;
        for(int i =0; i<arr.length;i++){
            min = i;
            for(int j = i; j<arr.length; j++){
                if (arr[j] < arr[min]){
                    min = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }

        return arr;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the elements of array separated by space: ");
        String input = sc.nextLine();
        String[] inputArray = input.split(" ");
        
        // Convert the array of strings to an array of integers
        int[] arr = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            arr[i] = Integer.parseInt(inputArray[i].trim());
        }

        System.out.println("Input array: ");
        System.out.println(Arrays.toString(arr));
        int[] sortedArray = SelectionSort(arr);
        
        System.out.println("Sorted array by selection sort: ");
        System.out.println(Arrays.toString(sortedArray));

    }
}
