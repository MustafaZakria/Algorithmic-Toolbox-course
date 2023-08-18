package week5;

import java.util.*;

public class LCS2 {

    private static int lcs2(int[] a, int[] b) {
        int[][] table = new int[b.length + 1][a.length + 1];

        for (int i = 1; i <= b.length; i++) {
            for (int j = 1; j <= a.length; j++) {
                if(i == 0 || j == 0) {
                    table[i][j] = 0;
                } else if (a[j - 1] == b[i - 1]) {
                    table[i][j] = table[i - 1][j - 1] + 1;
                } else {
                    table[i][j] = getMax(table[i - 1][j], table[i][j - 1], table[i - 1][j - 1]);
                }

            }
        }

        return table[b.length][a.length];
    }

    private static int getMax(int num_1, int num_2, int num_3) {
        return Math.max(num_1, Math.max(num_2, num_3));
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
}

