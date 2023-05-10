package week2;

import java.util.*;

public class FibonacciHuge {
    static long getFibonacciHugeNaive(long n, long m) {
        if(n <= 1)
            return n;
        long[][] matrix = {{1, 1}, {1, 0}};

        long[][] result = matrixPower(matrix, n - 1, m);
        return (int) (result[0][0]);
    }

    private static long[][] matrixPower(long[][] matrix, long power, long m) {
        long[][] result = {{1, 0}, {0, 1}}; //identity

        while (power > 0) {
            if (power % 2 == 1) {
                result = matrixMultiply(result, matrix, m);
            }

            matrix = matrixMultiply(matrix, matrix, m);
            power /= 2;
        }

        return result;
    }

    private static long[][] matrixMultiply(long[][] a, long[][] b, long m) {
        int rowA = a.length;
        int colB = b[0].length;
        int colA = a[0].length;

        long[][] result = new long[rowA][colB];

        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colB; j++) {
                for (int k = 0; k < colA; k++) {
                    result[i][j] += ((a[i][k] % m) * (b[k][j] % m)) % m;
                    result[i][j] %= m;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeNaive(n, m));
    }
}

