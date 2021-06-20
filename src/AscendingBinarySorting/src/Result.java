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



class Result {

    /*
     * Complete the 'rearrange' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY elements as parameter.
     */

    public static List<Integer> rearrange(List<Integer> elements) {
        // Write your code here
        // find number of '1' in each number binary format (Integer.toBinaryString(n, 2))
        // sort them by order
        // convert bin num into array of nums then sum
        List<Integer> result = new ArrayList<>();
        List<int[]> newList = new ArrayList<>();
        Map<Integer, Integer> newMap = new HashMap<>();
        int count = 0;

        for(Integer num: elements) {
            int[] bin = Integer.toBinaryString(num).chars().map(c -> c-'0').toArray();
            count = Arrays.stream(bin).sum();
            newList.add(bin);

            newMap.put(num, count);
        }

        System.out.println("Number map before counting is: " + newMap);

        Map<Integer, Integer> sortedMap = newMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        for(Map.Entry<Integer, Integer> key: sortedMap.entrySet()) {
            result.add(key.getKey());
        }

        System.out.println("Number map after counting is: " + sortedMap);

        return result;
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        List<Integer> input = new ArrayList<>();
        input.add(7); input.add(8); input.add(6); input.add(5);

        System.out.println("Should return -> [8, 5, 6, 7]\n" +
                "Actual Return Value: -> " + Result.rearrange(input));
    }
}
