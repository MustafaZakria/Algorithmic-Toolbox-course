package week3;

import java.util.*;
import java.math.BigInteger;


public class LargestNumber_NS {    // caused an error
    private static String largestNumber(String[] a) {
        //write your code here
        ArrayList<String> list = new ArrayList<>(Arrays.asList(a));

        list.sort((o1, o2) -> {
            String str = isBetter(o1, o2);
            if (str.equals(o1)) {
                return 1;
            } else if (str.equals(o2)) {
                return -1;
            }
            return 0;
        });

        StringBuilder result = new StringBuilder();
        for (String str : list) {
            result.insert(0, str);
        }

        BigInteger number = new BigInteger(result.toString());

        return number.toString();
    }

    private static String isBetter(String num1, String num2) {
        int integer1 = Integer.parseInt(num1);
        int integer2 = Integer.parseInt(num2);

        String min = String.valueOf(Math.min(integer1, integer2));
        String max = String.valueOf(Math.max(integer1, integer2));

        BigInteger number1 = new BigInteger(min+max);
        BigInteger number2 = new BigInteger(max+min);
        if(number1.compareTo(number2) > 0)
            return min;
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

