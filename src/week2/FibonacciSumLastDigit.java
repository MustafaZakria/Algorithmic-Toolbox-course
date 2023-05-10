package week2;

import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
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
                    result[i][j] += ((a[i][k] % 10) * (b[k][j] % 10)) % 10;
                    result[i][j] %= 10;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumNaive(n);
        System.out.println(s);
    }
}

