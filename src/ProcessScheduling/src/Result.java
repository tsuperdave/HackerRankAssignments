
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
     * Complete the 'minimumTime' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ability
     *  2. LONG_INTEGER processes
     */

    public static int minimumTime(List<Integer> ability, long processes) {
        // Write your code here
        // find min time to schedule all processes
        // after each scheduling, processor ability reduced to floor(ability / 2)

        // n = 5 (number of processors and size of ability[])
        // ability = [3, 1, 7, 2, 4]
        // processes = 15

        // sort List OR Collections.max(list) -> also store index
        // floor(el / 2) that index val
        // subtract that el from processes
        // if processes cannot be subtracted from more (i.e. 1) return how many iterations it took (while loop?)
        // iterate up (or add to counter) -> return this val
        int result = 1;
        double stored = processes;

        for (int i = result; i < ability.size(); result++) {
            double tempMax = Collections.max(ability);
            stored -= tempMax;
            int tempPos = ability.indexOf((int) tempMax);
            if (stored < 1) {
                return result;
            }
            double swap = Math.floor(ability.get(tempPos) / 2.0);
            ability.set(tempPos, (int) swap);

        }
        return result;
    }
}

class Solution {
    public static void main(String[] args) throws IOException {
        List<Integer> ability = new ArrayList<>();
        ability.add(3); ability.add(1); ability.add(7); ability.add(2); ability.add(4);
        int processes = 15;

        int expected = 4;

        System.out.println("Actual output = " + Result.minimumTime(ability, processes) +
        " and expected output is " + expected);
    }
}
