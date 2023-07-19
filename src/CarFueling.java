import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int result = 0;
        List<Integer> stops_list = new ArrayList<>();
        stops_list.add(0);
        for (int i : stops) {
            stops_list.add(i);
        }
        stops_list.add(dist);

        int distanceCovered = stops_list.get(0) + tank;
//        int temp = 0;
        for (int i = 0; i < stops_list.size() - 1; i++) {
//            if(stops_list.get(i) <= distanceCovered) {
//                temp = stops_list.get(i);
//            } else {
//                if( stops_list.get(i) > temp + tank) {
//                    return -1;
//                }
//                result++;
//                i--;
//                distanceCovered = temp + tank;
//            }
            if (stops_list.get(i + 1) > distanceCovered) {
                distanceCovered = stops_list.get(i) + tank;
                if (stops_list.get(i + 1) > distanceCovered) {
                    return -1;
                }
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
