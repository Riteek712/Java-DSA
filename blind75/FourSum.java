package blind75;

import java.util.*;

public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;

        for(int i =0 ; i< len ; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            // int t2 = target - nums[i];

            for(int j = i +1; j <len; j++){            
                if(j > i+1 && nums[j]==nums[j-1]) continue;

                int l = j +1;
                int k = len -1;

                while (l<k) {
                    int sum = nums[i] + nums[j] +nums[l] +nums[k];

                    if(sum > target){
                        k--;
                    }else if (sum < target){
                        l++;
                    }else{
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[l]);
                        temp.add(nums[k]);
                        res.add(temp);

                        l++;
                        k--;

                        while (k < l && nums[k]==nums[k-1]) k--; 
                        while (k < l && nums[l]==nums[l-1]) l++; 
                    }
                }

                
            }


        }
        return res;
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

        System.out.println("Result array: ");

        System.out.println(fourSum(arr, target));

    }
    
}
