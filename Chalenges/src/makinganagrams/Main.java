package makinganagrams;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {

        // sort both strings, check if equals
        // remove one character from both
        // sort check again
        // repeat

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        System.out.println(res);

        scanner.close();
    }
}
