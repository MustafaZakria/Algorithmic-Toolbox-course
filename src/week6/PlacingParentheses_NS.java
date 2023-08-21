package week6;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class PlacingParentheses_NS {
    private static long getMaximValue(String exp) {
        char[] operations = getOperations(exp);
        int[] operand = getOperands(exp);

        int len = operand.length + 1;
        long[][] minTable = new long[len][len];
        long[][] maxTable = new long[len][len];

        for (int i = 1; i <= operand.length; i++) {
            minTable[i][i] = operand[i - 1];
            maxTable[i][i] = operand[i - 1];
        }

        for(int i = 1; i < len - 1; i++) {
            for(int j = 1; j < len - i; j++) {
                int k = i + j;
                long[] temp = getMinAndMax(operations, minTable, maxTable, j, k);
                minTable[j][k] = temp[0];
                maxTable[j][k] = temp[1];
            }
        }
        return maxTable[1][len - 1];
    }

    private static long[] getMinAndMax(char[] operations, long[][] minTable, long[][] maxTable, int j, int k) {
        long min = Integer.MAX_VALUE;
        long max = Integer.MIN_VALUE;
        for(int i = j; i < k; i++){
            long a = eval(minTable[j][i], maxTable[i + 1][k], operations[i - 1]);
            long b = eval(maxTable[j][i], maxTable[i + 1][k], operations[i - 1]);
            long c = eval(minTable[j][i], minTable[i + 1][k], operations[i - 1]);
            long d = eval(maxTable[j][i], minTable[i + 1][k], operations[i - 1]);
            min = getMin(min, a, b, c, d);
            max = getMax(max, a, b, c, d);
        }
        return new long[]{min, max};
    }

    private static long getMax(long m, long a, long b, long c, long d) {
        return Collections.max(Arrays.asList(m, a, b, c, d));
    }

    private static long getMin(long m, long a, long b, long c, long d) {
        return Collections.min(Arrays.asList(m, a, b, c, d));
    }

    private static int[] getOperands(String exp) {
        int len = (int) Math.ceil((double) exp.length() / 2);
        int[] ops = new int[len];
        int counter = 0;
        for (int i = 0; i < exp.length(); i+=2) {
            ops[counter] = Integer.parseInt(String.valueOf(exp.charAt(i)));
            counter++;
        }
        return ops;
    }

    private static char[] getOperations(String exp) {
        char[] ops = new char[exp.length() / 2];
        int counter = 0;
        for (int i = 1; i < exp.length(); i+=2) {
            ops[counter] = exp.charAt(i);
            counter++;
        }
        return ops;
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

