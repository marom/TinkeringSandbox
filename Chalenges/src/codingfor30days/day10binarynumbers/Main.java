package codingfor30days.day10binarynumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        List<Integer> binary = base10ToBase2(n);
        int i = consecutive1s(binary);
        printConsecutive1s(i);
        scanner.close();
    }

    private static void printConsecutive1s(int i) {
        System.out.println(i);
    }

    private static int consecutive1s(List<Integer> binary) {

        int counter = 0;
        int max = 0;

        for (int ii : binary) {

            if (ii == 1) {
                counter++;
            } else {
                counter = 0;
            }
            if (max < counter)
                max = counter;
        }
        return max;
    }


    private static List<Integer> base10ToBase2(int n) {

        List<Integer> base2 = new ArrayList<>();
        while (n > 0) {
            int reminder = n % 2;
            n = n / 2;
            base2.add(reminder);
        }

        List<Integer> base2valid = new ArrayList<>();
        for (int i = base2.size() - 1; i >= 0; i--) {
            base2valid.add(base2.get(i));
        }
        return base2valid;
    }
}
