package basicQuestions;

import java.util.*;

public class CharacterSeen {
    public static boolean hasRepeatedCharacters(String s) {
        Set<Character> seen = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (seen.contains(c)) {
                return true;
            }
            seen.add(c);
        }
        return false;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(hasRepeatedCharacters(str)); // Output: true
        System.out.println("hasRepeatedCharacters(hello)"); // Output: true
        System.out.println(hasRepeatedCharacters("hello")); // Output: true
        System.out.println("hasRepeatedCharacters(world)");
        System.out.println(hasRepeatedCharacters("world"));
    }
}
