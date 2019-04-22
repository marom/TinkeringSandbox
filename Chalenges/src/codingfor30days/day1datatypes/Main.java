package codingfor30days.day1datatypes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";

        Scanner scan = new Scanner(System.in);

        /* Read and save an integer, double, and String to your variables.*/
        // Note: If you have trouble reading the entire String, please go back and review the Tutorial closely.
        int ii = scan.nextInt();
        scan.nextLine();
        double dd = scan.nextDouble();
        scan.nextLine();
        String ss = scan.nextLine();

        int sumOfInt = i + ii;
        Double truncatedDouble = BigDecimal.valueOf(d + dd)
                .setScale(1, RoundingMode.HALF_UP)
                .doubleValue();
        /* Print the sum of both integer variables on a new line. */
        System.out.println(sumOfInt);
        /* Print the sum of the double variables on a new line. */
        System.out.println(truncatedDouble);
        /* Concatenate and print the String variables on a new line;
            the 's' variable above should be printed first. */
        System.out.println(s + ss);

        scan.close();
    }
}
