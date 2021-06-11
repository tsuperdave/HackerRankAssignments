import java.io.IOException;
import java.util.List;
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
     * Complete the 'maxMin' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER k
     */

    public static int maxMin(List<Integer> arr, int k) {
        // Write your code here
        List<Integer> list = new ArrayList<>();

        if(k == 1) {
            return Collections.max(arr);
        }

        for( int i = 0; i < arr.size(); i++){
            List<Integer> tempList;
            int combined = i+k;
            if(combined <= arr.size()) {
                tempList = arr.subList(i,combined);
                System.out.println(tempList);
                list.add(Collections.min(tempList));
            }


        }
        return Collections.max(list);
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        List<Integer> inputList1 = new ArrayList<>();
        inputList1.add(1); inputList1.add(2); inputList1.add(3); inputList1.add(4); inputList1.add(5);
        int subArrModTest1 = 2;

        List<Integer> inputlist2 = new ArrayList<>();
        inputlist2.add(1); inputlist2.add(2); inputlist2.add(3); inputlist2.add(1); inputlist2.add(2);
        int subArrModTest2 = 1;

        List<Integer> inputlist3 = new ArrayList<>();
        inputlist3.add(1); inputlist3.add(1); inputlist3.add(1);
        int subArrModTest3 = 2;

        List<Integer> inputlist4 = new ArrayList<>();
        inputlist4.add(2); inputlist4.add(5); inputlist4.add(4); inputlist4.add(6); inputlist4.add(8);
        int subArrModTest4 = 3;

        System.out.println("Test 1 = " + Result.maxMin(inputList1, subArrModTest1) + ", expected 4"); // 1, 2, 3, 4, 5
        System.out.println("Test 2 = " + Result.maxMin(inputlist2, subArrModTest2) + ", expected 3"); // 1, 2, 3, 1, 2
        System.out.println("Test 3 = " + Result.maxMin(inputlist3, subArrModTest3) + ", expected 1"); // 1, 1, 1
        System.out.println("Test 4 = " + Result.maxMin(inputlist4, subArrModTest4) + ", expected 4"); // 2, 5, 4, 6, 8
    }
}
