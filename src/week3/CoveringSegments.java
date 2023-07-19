package week3;

import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        List<Segment> segmentsList = new ArrayList<>(Arrays.asList(segments));
        segmentsList.sort((seg1, seg2) -> {
            if (seg1.end > seg2.end) {
                return 1;
            } else if (seg1.end < seg2.end) {
                return -1;
            }
            return 0;
        });

        List<Integer> points = new ArrayList<>();
        for (int i = 0; i < segmentsList.size(); i++) {
            if (segmentsList.get(i).end != -1) {
                int point = segmentsList.get(i).end;
                points.add(point);
                segmentsList.get(i).end = -1;  //covered segment
                for (int j = i + 1; j < segmentsList.size(); j++) {
                    if (segmentsList.get(j).start <= point && segmentsList.get(j).end >= point) {
                        segmentsList.get(j).end = -1;   //covered segment
                    }
                }
            }
        }

        int[] result = new  int[points.size()];
        for(int i = 0; i < points.size(); i++) {
            result[i] = points.get(i);
        }
        return result;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}


 
