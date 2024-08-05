package blind75;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * Problem Statement:

Given an array of integers nums and an integer target, return the indices of the two numbers such that they add up to the target.

Assumptions:

Each input would have exactly one solution.
You may not use the same element twice.
 */

public class TwoSum {

    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0 ; i< nums.length; i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }

        return null;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Array: ");
        String input = sc.nextLine();
        String[] inputArray = input.split(" ");
        int[] arr = new int[inputArray.length];
        for(int i =0; i< inputArray.length; i++){
            arr[i] =  Integer.parseInt(inputArray[i].trim());
        }
    
        System.out.println("Target: ");
        int target = sc.nextInt();

        System.out.println("Inputed array: ");
        System.out.println(Arrays.toString(arr));

        int[] result = twoSum(arr, target);
        if ( result != null){
            System.out.println("The Target element found.");
            System.out.println("The element indexs.");
            System.out.println(Arrays.toString(result));
        }else{
            System.out.println("The Target element not found.");
        }
                
    }
}


