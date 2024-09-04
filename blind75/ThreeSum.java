package blind75;

import java.util.*;


public class ThreeSum {
    // Function to find triplets having sum equals to target
    public static List<List<Integer>> threeSum(int[]nums, int target){
        // List to store the triplets that sum up to target
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        // Sort the input array nums
        Arrays.sort(nums);

        // Iterate through the array to find triplets
        for(int i = 0; i<n; i++){
            // Skip duplicates
            if(i > 0 && nums[i] == nums[i-1]) continue;
             // Two pointers approach
            int j = i +1;
            int k = n -1;

            while (j < k) {
                int sum = nums[i] + nums[j] +nums[k];
                if(sum < target){
                    j++;
                }else if (sum > target){
                    k --;
                }else{
                    // Found a triplet that sums up to target
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    ans.add(temp);

                    // Skip duplicates
                    j++;
                    k--;
                    while(j < k && nums[j-1]== nums[j]) j++;
                    while(j < k && nums[k-1]== nums[k]) k++;
                }
                
            }
        }
        return ans;
    }
    public static void main(String[] args) {
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

        System.out.println(threeSum(arr, target));

    }
}
