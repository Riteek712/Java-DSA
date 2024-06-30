package sorting;

import java.util.Arrays;

public class MergeSort {

    int[] array, tempMergeArr;
    int length;

    public static void main(String[] args) {
        int[] inputArr = {48, 36, 52, 19, 21};
        MergeSort ms = new MergeSort();
        ms.sort(inputArr);
        System.out.println(Arrays.toString(inputArr));
    }
    
    public void sort (int[] inputArr){
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergeArr = new int[length];
        divideArr(0, length - 1);
    }

    public void divideArr(int low, int high){
        if(low<high){
            int middle = low + (high - low)/2;
            // This will sort the left side of array.
            divideArr(low, middle);
            // This will sort the right side of array.
            divideArr(middle +1, high);
            mergeArr(low, middle, high);
        }
    }

    public void mergeArr( int low, int middle, int high){
        for (int i =low; i<=high; i++){
            tempMergeArr[i] = array[i];
        }
        int i = low;
        int j = middle +1;
        int k = low;
        while ( i <= middle && j <= high){
            if(tempMergeArr[i]<=tempMergeArr[j]){
                array[k] = tempMergeArr[i];
                i++;
            }else{
                array[k] = tempMergeArr[j];
                j++;
            }
            k++;
        }

        while (i<=middle) {
            array[k] = tempMergeArr[i];
            k++;
            i++;
            
        }
    }
}
