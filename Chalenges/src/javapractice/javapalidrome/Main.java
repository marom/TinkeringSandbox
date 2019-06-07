package javapractice.javapalidrome;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* verify that none of the pairs of characters from each end of the String fulfills the Predicate condition. */
        boolean b = IntStream.range(0, A.length() / 2)
                .noneMatch(i -> A.charAt(i) != A.charAt(A.length() - i - 1));
        System.out.println(b ? "Yes" : "No");
    }
}
