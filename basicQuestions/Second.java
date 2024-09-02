package basicQuestions;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
class Second
{
static private int secondSmallest(int[] arr, int n)
{
	if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array should have at least two elements.");
        }

        // Sort the array in ascending order
        Arrays.sort(arr);
	int small = Integer.MAX_VALUE;
	int second_small = Integer.MAX_VALUE;
	int i;
	for (i = 0; i < n; i++)
	{
	   if (arr[i] < small)
	   {
		  second_small = small;
		  small = arr[i];
	   }
	   else if (arr[i] < second_small && arr[i] != small)
	   {
		  second_small = arr[i];
	   }
	}
   return second_small;
}
static private int secondLargest(int[] arr, int n)
{
	if (arr == null || arr.length < 2) {
		throw new IllegalArgumentException("Array should have at least two elements.");
	}

	// Sort the array in ascending order
	Arrays.sort(arr);
	int large = Integer.MIN_VALUE;
	int second_large = Integer.MIN_VALUE;
	int i;
	for (i = 0; i < n; i++)
	{
		if (arr[i] > large)
		{
			second_large = large;
			large = arr[i];
		}

		else if (arr[i] > second_large && arr[i] != large)
		{
			second_large = arr[i];
		}
	}
	return second_large;
}

public static void main(String[] args)
{
	Scanner sc =  new Scanner(System.in);
	System.out.println("Enter array number separated by a ' ': ");
	String input = sc.nextLine();
	String[] inputArrStr = input.split(" " );
	int len = inputArrStr.length;
	int[] arr = new int[len];
	for(int i = 0; i < len; i++){
		arr[i] = Integer.parseInt(inputArrStr[i]);
	}
	System.out.println(arr);
	System.out.println("Second smallest number: " + secondSmallest(arr, len));
	System.out.println("Second largest number: " + secondLargest(arr, len));

}

}

