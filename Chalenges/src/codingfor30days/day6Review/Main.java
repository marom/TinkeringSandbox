package codingfor30days.day6Review;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        List<String> words = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            String word = sc.nextLine();
            words.add(word);
        }

        for (String word : words) {
            checkWord(word);
        }

    }

    private static void checkWord(String word){

        String even = "";
        String odd = "";

        for (int i = 0; i <= word.length() - 1; i++) {
            if (i % 2 == 0) {
                even = even + word.charAt(i);
            } else {
                odd = odd + word.charAt(i);
            }
        }
        System.out.println(even + " " + odd);
    }
}
