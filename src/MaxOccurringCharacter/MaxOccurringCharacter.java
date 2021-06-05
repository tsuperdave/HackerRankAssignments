package MaxOccurringCharacter;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;


public class Result {

    /*
     * Complete the 'maximumOccurringCharacter' function below.
     *
     * The function is expected to return a CHARACTER.
     * The function accepts STRING text as parameter.
     */

    public static char maximumOccurringCharacter(String text) {
        // how many total ASCII chars are there?
        // only count "a-z", "A-Z", "0-9"; 26+26+10
        // "aaabbacacb" -> [a, a, a, b, b, a, c, a, c, b]
        //                 [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        //
        //        int INSTANCE_COUNT = 62;
        //        int LENGTH_OF_INPUT = text.length();
        //        int count[] = new int[INSTANCE_COUNT];

        HashMap<Character, Integer> charCount = new HashMap<>();
        char[] inputCharArr = text.toCharArray();

        for(Character c: inputCharArr) {
            if(charCount.containsKey(c)) {
                charCount.put(c, charCount.get(c) + 1);
            } else {
                charCount.put(c, 1);
            }
        }

        // possible store counts in array, lowest index with highest count (or == count) should be first returned
        // returns String
        return Collections.max(charCount.entrySet(), Map.Entry.comparingByValue()).getKey(); // char;

    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String text = bufferedReader.readLine();

        char result = FunWithAnagrams.Result.maximumOccurringCharacter(text);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
