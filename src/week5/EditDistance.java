package week5;

import java.util.*;

class EditDistance {
    public static int editDistance(String s, String t) {
        int[][] table = new int[t.length() + 1][s.length() + 1];

        for (int i = 1; i <= t.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if(i == 0 || j == 0) {
                    table[i][j] = 0;
                } else if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    table[i][j] = table[i - 1][j - 1];
                } else {
                    table[i][j] = getMin(table[i - 1][j], table[i][j - 1], table[i - 1][j - 1]) + 1;
                }
            }
        }

        return table[t.length()][s.length()];
    }

    private static int getMin(int num_1, int num_2, int num_3) {
        return Math.min(num_1, Math.min(num_2, num_3));
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        String t = scan.next();

        System.out.println(editDistance(s, t));
    }

}
