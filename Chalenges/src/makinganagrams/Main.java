package makinganagrams;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {

        // an array for every letter in alphabet
        int[] letterCounts = new int[26];

        // count a letter occurrence in the sting
        for(char c : a.toCharArray()){
            letterCounts[c-'a']++;
        }

        // remove count if a letter exist in string two
        for(char c : b.toCharArray()){
            letterCounts[c-'a']--;
        }


        //Ex. String: aaaab bbaaa
        //Array: [1, -1, 0, 0, 0, ...etc]
        // We need to remove 1 a and 1 b to make an anagram, so: Math.abs(1) + Math.abs(-1) == 2, which is the correct answer.
        int result = 0;
        for(int i : letterCounts){
            result += Math.abs(i);
        }
        return result;
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
