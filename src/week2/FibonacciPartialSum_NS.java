package week2;

import java.util.*;

public class FibonacciPartialSum_NS {
    static long getFibonacciPartialSumNaive(long from, long to) {
        if(from == to)
            return getFibonacciSumSquaresNaive(from);

        long start = getFibonacciSumSquaresNaive(from + 1);
        long end = getFibonacciSumSquaresNaive(to + 1);

        return Math.abs(end - start) % 10;
    }

    private static long getFibonacciSumSquaresNaive(long n) {
        if(n <= 1)
            return n;
        long[][] matrix = {{1, 1}, {1, 0}};

        long[][] result = matrixPower(matrix, n + 1);

        if(result[0][0] == 0)
            return 9;
        return (int) (result[0][0]) - 1;
    }

    private static long[][] matrixPower(long[][] matrix, long power) {
        long[][] result = {{1, 0}, {0, 1}}; //identity

        while (power > 0) {
            if (power % 2 == 1) {
                result = matrixMultiply(result, matrix);
            }

            matrix = matrixMultiply(matrix, matrix);
            power /= 2;
        }

        return result;
    }

    private static long[][] matrixMultiply(long[][] a, long[][] b) {
        int rowA = a.length;
        int colB = b[0].length;
        int colA = a[0].length;

        long[][] result = new long[rowA][colB];

        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colB; j++) {
                for (int k = 0; k < colA; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumNaive(from, to));
    }
}

