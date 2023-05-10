package week2;

import java.util.Scanner;

public class GreatestCommonDivisor {
    public static int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }

        int newA = a % b;

        return getGCD(b, newA);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        System.out.println(getGCD(a, b));
    }
}
