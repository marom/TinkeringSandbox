package javapractice.javaanagram;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static boolean isAnagram(String a, String b) {
        // Complete the function
        if (a.length() != b.length()) return false;

        a = a.toLowerCase();
        b = b.toLowerCase();

        //create an arrays of all alphabet letters
        char Aarr[] = new char[26];
        char Barr[] = new char[26];

        //count a letter occurrence in a string
        for(int i=0 ; i<a.length() ; i++)
            Aarr[a.charAt(i)-97]++;
        for (int i=0 ; i<b.length() ; i++)
            Barr[b.charAt(i)-97]++;

        return Arrays.equals(Aarr, Barr);
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
