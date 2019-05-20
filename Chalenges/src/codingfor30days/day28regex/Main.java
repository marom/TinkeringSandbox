package codingfor30days.day28regex;

import java.util.*;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        List<String> names = new ArrayList<>();

        for (int NItr = 0; NItr < N; NItr++) {
            String[] firstNameEmailID = scanner.nextLine().split(" ");

            String firstName = firstNameEmailID[0];

            String emailID = firstNameEmailID[1];

            if (emailID.contains("@gmail.com"))
                names.add(firstName);
        }

        Collections.sort(names);

        for (String name : names) {
            System.out.println(name);
        }
        scanner.close();
    }
}
