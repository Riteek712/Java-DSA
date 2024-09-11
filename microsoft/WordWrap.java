package microsoft;
import java.util.*;
/*
 * Problem statement
You are given ‘N’ words of various lengths, now you have to arrange these words in such a way that each line contains at most ‘M’ characters and each word is separated by a space character. The cost of each line is equal to the cube of extra space characters required to complete ‘M’ characters in that particular line. Total cost is equal to the sum of costs of each line.

Your task is to form this arrangement with the minimum cost possible and return the minimum total cost.

Note:
The length of each word should be less than or equal to ‘M’.

You can’t break a word, i.e. the entire word should come in the same line and it must not be the case that a part of it comes in the first line and another part on the next line.
 */
public class WordWrap {
    public static int wordWrap(String[] words, int M, int N) {
        int[] wordLengths = new int[N];

        // Calculate the length of each word
        for (int i = 0; i < N; i++) {
            wordLengths[i] = words[i].length();
        }

        // dp[i] will store the minimum cost for arranging words from i to N-1
        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE); // Initialize dp with a large value
        dp[N] = 0; // No extra cost for the last word

        // Start from the last word and work backwards
        for (int i = N - 1; i >= 0; i--) {
            int length = 0; // The total length of words in the current line
            for (int j = i; j < N; j++) {
                length += wordLengths[j]; // Add the current word length
                if (j > i) length += 1; // Add a space if it's not the first word

                if (length > M) break; // If the length exceeds M, stop considering this line

                // Calculate the extra spaces in the current line
                int extraSpaces = M - length;

                // Calculate the cost of the current arrangement (cube of extra spaces)
                int cost = (j == N - 1) ? 0 : extraSpaces * extraSpaces * extraSpaces;

                // Update dp[i] by considering the current line (i to j)
                dp[i] = Math.min(dp[i], cost + dp[j + 1]);
            }
        }

        // The answer is the minimum cost for arranging words from the first word (dp[0])
        return dp[0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases
        while (T-- > 0) {
            int N = sc.nextInt(); // Number of words
            int M = sc.nextInt(); // Maximum characters per line
            String[] words = new String[N];
            
            // Read the words
            for (int i = 0; i < N; i++) {
                words[i] = sc.next();
            }

            // Call the function to calculate the minimum cost
            int result = wordWrap(words, M, N);
            System.out.println(result);
        }
        sc.close();
    }
}
