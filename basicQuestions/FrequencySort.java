package basicQuestions;
import java.util.*;

public class FrequencySort {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the numbers separated by spaces: ");
        String input = sc.nextLine();
        String[] arrayString = input.split(" ");
        int[] arr = new int[arrayString.length];
        for(int i = 0; i < arrayString.length; i++){
            arr[i] = Integer.parseInt(arrayString[i]);
        }
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i = 0; i<arr.length;i++){
            freq.put(arr[i], freq.getOrDefault(arr[i], 0)+1);
        }
        System.out.println(freq);

        // Convert freq to a list of map entries.
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(freq.entrySet());

        // sort the list based on frequency value.
        entryList.sort((entry1, entry2)-> entry2.getValue().compareTo(entry1.getValue()));

        for (Map.Entry<Integer, Integer> entry : entryList) {
            System.out.println("Element " + entry.getKey() + " occurs " + entry.getValue() + " times.");
        }

    }
}
