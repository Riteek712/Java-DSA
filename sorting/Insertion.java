package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class Insertion {

    public static int[] InsertionSort( int[] data){
        int n = data.length;
        int temp, j;
        for(int i =1; i < n; i++){
            temp = data[i];
            j =i;
            while(j >0 && data[j-1]>temp){
                data[j] = data[j-1];
                j = j-1;
            }
            data[j] = temp;

        }
        return data;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array elements separated by space: ");
        String input = sc.nextLine();
        String[] inputArray = input.split(" ");
        int arr[] = new int[inputArray.length];
        for(int i =0; i< inputArray.length;i++){
            arr[i] = Integer.parseInt(inputArray[i].trim());
        }
        System.out.println("Inputed array");
        System.out.println(Arrays.toString(arr));
        int[] sortedArray = InsertionSort(arr);
        System.out.println("Sorted array");
        System.out.println(Arrays.toString(sortedArray));


    }
}
