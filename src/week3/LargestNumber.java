package week3;

import java.util.*;

public class LargestNumber {
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
        return result.toString();
    }

    private static String isBetter(String num1, String num2) {
        int integer1 = Integer.parseInt(num1);
        int integer2 = Integer.parseInt(num2);

        int len = Math.max(num1.length(), num2.length());
        String min = String.valueOf(Math.min(integer1, integer2));
        String max = String.valueOf(Math.max(integer1, integer2));

        int counter = 0;
        for (int i = 0; i < len && counter < min.length(); i++) {
            int i1 = Integer.parseInt(String.valueOf(min.charAt(counter)));
            int i2 = Integer.parseInt(String.valueOf(max.charAt(i)));

            if (i1 > i2) {
                return min;
            } else if (i1 < i2) {
                return max;
            } else if (counter < min.length() - 1) {
                counter++;
            }
        }

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

