package repeatedstring;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {

        long count = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == 'a')
                count++;

        // at least k repetition are required
        long repetitions = n / s.length();
        count = count * repetitions;

        // if n is not the multiple of the string size check for the remaining
        // repeating character.
        for (int i = 0; i < n % s.length(); i++) {
            if (s.charAt(i) == 'a')
                count++;
        }

        return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        System.out.println(result);


        scanner.close();
    }
}
