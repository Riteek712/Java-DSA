package sorting;

import java.util.Arrays;

public class Bubble {
    public static int[] bubbleSort( int[] arr){
    // We compare ele to it's adjesent element and swap if the element on the right is smaller.
        int n =  arr.length;
        for(int i = 0; i< n-1; i++){ // We need N - 1 iterations to sort the array.
            for(int j = 0; j < n-1-i; j++ ){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {5,7,5,4,10,-2, 6,3};
        arr = bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        
    }
}
