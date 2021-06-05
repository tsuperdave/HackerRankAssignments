package FunWithAnagrams;

import sun.reflect.generics.tree.Tree;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Result {
    /*
     * Complete the 'funWithAnagrams' function below.
        *
        * The function is expected to return a STRING_ARRAY.
         * The function accepts STRING_ARRAY text as parameter.
         */
    public static void main(String[] args) {
        List<String> listOfWords = new ArrayList<>();
        listOfWords.add("code");
        listOfWords.add("aaagmnrs");
        listOfWords.add("anagrams");
        listOfWords.add("doce");
        System.out.println("List of words is: " + listOfWords);
        System.out.println(funWithAnagrams(listOfWords));

    }

    public static List<String> funWithAnagrams(List<String> text) {
        // Write your code here
        // add first word to a new arraylist,
            // compare each word after and if both contain the same contents/length, skip
            // else add the word to the new list

        List<String> result = new ArrayList<>();
        boolean flag = false;

        result.add(text.get(0));

        for(int i = 1; i < text.size(); i++) {

            char[] lettersInInputList = text.get(i).toCharArray(); // "[c, o, d, e]"
            Arrays.sort(lettersInInputList);

            for(String word: result) {
                char[] lettersInReturnList = word.toCharArray();
                Arrays.sort(lettersInReturnList);

                if(!Arrays.equals(lettersInInputList, lettersInReturnList)) {
                    flag = false;
                } else {
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                result.add(text.get(i));
            }

        }
        Collections.sort(result);
        return result;
    }

}
