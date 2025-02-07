package week5;

import java.util.*;

public class LCS3 {

    private static int lcs3(int[] a, int[] b, int[] c) {
        int[][][] table = new int[b.length + 1][a.length + 1][c.length + 1];

        for (int i = 1; i <= b.length; i++) {
            for (int j = 1; j <= a.length; j++) {
                for (int k = 0; k <= c.length; k++) {
                    if (i == 0 || j == 0 || k ==0) {
                        table[i][j][k] = 0;
                    } else if (a[j - 1] == b[i - 1] && b[i - 1] == c[k - 1]) {
                        table[i][j][k] = table[i - 1][j - 1][k - 1] + 1;
                    } else {
                        table[i][j][k] = getMax(table[i - 1][j][k], table[i][j - 1][k], table[i][j][k - 1]);
                    }

                }
            }
        }

        return table[b.length][a.length][c.length];
    }

    private static int getMax(int num_1, int num_2, int num_3) {
        return Math.max(num_1, Math.max(num_2, num_3));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}

