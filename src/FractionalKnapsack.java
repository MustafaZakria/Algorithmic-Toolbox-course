import java.util.*;

public class FractionalKnapsack {

    private static class Item {
        int weight;
        int value;
        Item(int w, int v) {
            weight = w;
            value = v;
        }
    }
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        List<Item> items = new ArrayList<>();
        for(int i = 0; i < values.length; i++) {
            items.add(new Item(weights[i], values[i]));
        }

        items.sort((o1, o2) -> {
            if (o1.value / o1.weight > o2.value / o2.weight) {
                return -1;
            } else if (o1.value / o1.weight < o2.value / o2.weight) {
                return 1;
            }
            return 0;
        });

        double totalValue = 0;
        for(int i = 0; i < values.length; i++) {
            if(capacity == 0)
                return totalValue;

            int w = Math.min(items.get(i).weight, capacity);
            totalValue+= (w * ((double)items.get(i).value / items.get(i).weight));
            capacity-= w;
        }

        return Double.parseDouble(String.format("%.4f", totalValue));
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
