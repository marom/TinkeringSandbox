package codingfor30days.day3conditionals;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int myInt = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        boolean isEven = (myInt % 2) == 0;

        if (myInt < 1 && myInt > 100) {
            System.out.println("Out of range.");
        } else if (! isEven) {
            System.out.println("Weird");
        } else if (isEven && (myInt >= 2 && myInt <=5)){
            System.out.println("Not Weird");
        } else if (isEven && (myInt >= 6 && myInt <= 20)) {
            System.out.println("Weird");
        } else if (isEven && myInt > 20) {
            System.out.println("Not Weird");
        }

        scanner.close();
    }
}
