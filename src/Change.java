import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        int result = 0;
//        while (m > 0) {
//            if (m % 10 == 0) {
//                m -= 10;
//            } else if (m % 5 == 0) {
//                m -= 5;
//            } else {
//                m--;
//            }
//            result++;
//        }

        if(m >= 10) {
            result += (m / 10);  //10 coins
            m = m % 10;
        }

        if(m >= 5) {
            result++; //5 coin
            m -= 5;
        }

        result += m; //1 coins

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));
    }
}

