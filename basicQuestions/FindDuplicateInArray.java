package basicQuestions;

import java.util.ArrayList;

public class FindDuplicateInArray {

    public static int findDuplicate(ArrayList<Integer> arr, int n){
        // Intialise the fast and slow pointer.
        int slow = arr.get(0);
        int fast = arr.get(0);

        do {
            // System.out.println("l1");
            slow = arr.get(slow);
            fast = arr.get(arr.get(fast));
        }while(slow != fast);

        slow  = arr.get(0);

        while(slow != fast){
            // System.out.println("l2");
            slow = arr.get(slow);
            fast = arr.get(fast);
        }

        return fast;

    }
    
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(4);
        arr.add(2);
        arr.add(2);
        int n = arr.size();
        System.out.println(findDuplicate(arr, n)); // Output: 2
    }
}
