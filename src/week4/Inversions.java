package week4;

import java.util.*;

public class Inversions {

    private static long getNumberOfInversions(int[] a, int left, int right) {
        long numberOfInversions = 0;
        if (right <= left + 1) {
            return numberOfInversions;
        }
        int ave = (left + right) / 2;
        numberOfInversions += getNumberOfInversions(a, left, ave);
        numberOfInversions += getNumberOfInversions(a, ave, right);

        return getResult(a, left, ave, right, numberOfInversions);
    }

    private static long getResult(int[] a, int left, int ave, int right, long numberOfInversions) {
        int[] copy1 = new int[ave - left];
        int[] copy2 = new int[right - ave];

        for (int i = 0; i < copy1.length; i++) {
            copy1[i] = a[left + i];
        }
        for (int j = 0; j < copy2.length; j++) {
            copy2[j] = a[ave + j];
        }

        int count1 = 0, count2 = 0;
        while (count1 < copy1.length && count2 < copy2.length) {
            if (copy1[count1] <= copy2[count2]) {
                a[left] = copy1[count1];
                count1++;
                numberOfInversions += count2;
            } else {
                // copy1 > copy2
                a[left] = copy2[count2];
                count2++;
            }
            left++;
        }
        while (count2 < copy2.length) {
            a[left] = copy2[count2];
            count2++;
            left++;
        }
        while (count1 < copy1.length) {
            a[left] = copy1[count1];
            count1++;
            left++;
            numberOfInversions += count2;
        }
        return numberOfInversions;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
//        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, 0, a.length));
    }
}

