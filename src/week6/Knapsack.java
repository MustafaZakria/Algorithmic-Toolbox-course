package week6;

import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        int lenRow = w.length + 1,
                lenCol = W + 1;
        int[][] table = new int[lenRow][lenCol];

        for (int i = 0; i < lenRow; i++) {
            for (int j = 0; j < lenCol; j++) {
                if (i == 0 || j == 0) {
                    table[i][j] = 0;
                    continue;
                }
                table[i][j] = table[i - 1][j];
                if (j >= w[i - 1]) {
                    int val = table[i - 1][j - w[i - 1]] + w[i - 1];
                    if(val > table[i][j]) {
                        table[i][j] = val;
                    }
                }
            }
        }


        return table[w.length][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

