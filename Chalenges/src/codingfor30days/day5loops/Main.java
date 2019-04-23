package codingfor30days.day5loops;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        scanner.close();

        for (int i = 0; i < 10; i++) {
            System.out.println(n + " x " + (i + 1) + " = " + n*(i + 1));
        }
    }
}
