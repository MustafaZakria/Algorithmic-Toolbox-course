package week5;

import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) { //1, 3, 4

        int[] table = new int[m + 1];
        table[0] = 0;

        for (int i = 1; i <= m; i++) {
            table[i] = Integer.MAX_VALUE;
            for (int c : new int[]{1, 3, 4}) {
                if(i >= c) {
                    int temp = table[i - c] + 1;
                    if(temp < table[i]) {
                        table[i] = temp;
                    }
                }
            }
        }

        return table[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

