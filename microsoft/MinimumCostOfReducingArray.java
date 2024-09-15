package microsoft;

import java.util.Arrays;
/*
 * Problem statement
You are given an array 'ARR' consisting of 'N' positive integers, and you need to reduce the size of the array to 1 by performing an operation several number of times. In a single operation, you can merge any two adjacent elements of the array, and the cost of merging will be equal to the sum of those two elements. Find the minimum cost of reducing the given array by performing this operation several number of times.

In a single merge operation, the two elements are removed, and their sum is inserted at its place, hence decreasing the size of the array by 1 after each operation. For eg: Consider the array A1, A2, Ai-2, Ai-1, Ai, Aj, Aj+1, Aj+2 ,,,, An. Let the operation be performed on two indices i and j, So after merging the array will look like A1, A2, Ai-2, Ai-1, Ai+Aj, Aj+1, Aj+2,,,, An.

Note:

Note that the given operation will be performed only 'N'-1 times, where 'N' is the size of the given array.
 */

public class MinimumCostOfReducingArray {
    public static int findMinCost(int[] arr, int n) {
        // dp[i][j] will store the minimum cost to merge the subarray arr[i...j]
        int[][] dp = new int[n][n];
        
        // Prefix sum array to store the cumulative sum of elements
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }

        // Iterate over subarray lengths
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1; // Subarray endpoints (i, j)
                dp[i][j] = Integer.MAX_VALUE;

                // Try merging at every possible position
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + (prefixSum[j + 1] - prefixSum[i]);
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        // The answer will be the cost of merging the entire array
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        // Sample Input 1
        int[] arr1 = {1, 3, 7};
        System.out.println(findMinCost(arr1, arr1.length));  // Output: 15

        // Sample Input 2
        int[] arr2 = {3, 2, 4, 1};
        System.out.println(findMinCost(arr2, arr2.length));  // Output: 20
    }
}
