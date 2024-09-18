package basicQuestions;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveDublicates1 {
    // Function to remove duplicates from the array
    public static int removeDuplicates(int[] nums) {
        // Edge case: if array is empty
        if (nums.length == 0) {
            return 0;
        }
        
        // Initialize pointer for unique elements
        int i = 0;
        
        // Iterate through the array
        for (int j = 1; j < nums.length; j++) {
            /*If current element is different 
            from the previous unique element*/
            if (nums[i] != nums[j]) {
                /* Move to the next position in 
                the array for the unique element*/
                i++;
                /* Update the current position 
                   with the unique element*/
                nums[i] = nums[j];
            }
        }
        System.out.println(Arrays.toString(nums));
        
        // Return the number of unique elements
        return i + 1;
    }
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array elements seprated by ' ': ");
        String input = sc.nextLine();
        String[] inputArr =  input.split(" ");
        int[] arr = new int[inputArr.length];
        for(int i = 0; i < inputArr.length; i++){
            arr[i] = Integer.parseInt(inputArr[i]);
        }
        System.out.println("Solution: ");
        System.out.println(removeDuplicates(arr));
        sc.close();
    }
}
