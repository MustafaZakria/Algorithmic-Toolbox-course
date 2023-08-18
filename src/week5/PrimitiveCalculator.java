package week5;

import java.util.*;

public class PrimitiveCalculator {
//    private static List<Integer> optimal_sequence(int n) {
//        List<Integer> sequence = new ArrayList<Integer>();
//        while (n >= 1) {
//            sequence.add(n);
//            if (n % 3 == 0) {
//                n /= 3;
//            } else if (n % 2 == 0) {
//                n /= 2;
//            } else {
//                n -= 1;
//            }
//        }
//        Collections.reverse(sequence);
//        return sequence;
//    }

    private static List<Integer> optimal_sequence(int m) { //1, 3, 4

        int[] table = new int[m + 1];
        int[] indices = new int[m + 1];
        table[0] = 0;
        table[1] = 0;

        for (int i = 2; i <= m; i++) {
            table[i] = Integer.MAX_VALUE;
            for (int c : new int[]{1, 2, 3}) {
                if(i >= c) {
                    int temp, index;
                    if(c == 1) {
                        temp = table[i - c] + 1;
                        index = i - c;
                    } else if (i % c == 0) {
                        temp = table[i / c] + 1;
                        index = i / c;
                    } else {
                        continue;
                    }

                    if(temp < table[i]) {
                        table[i] = temp;
                        indices[i] = index;
                    }
                }
            }
        }
        List<Integer> sequence = new ArrayList<>();
        int j = m;
        while (j != 1) {
            sequence.add(j);
            j = indices[j];
        }
        sequence.add(1);
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

