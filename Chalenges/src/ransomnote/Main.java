package ransomnote;

import java.util.Hashtable;
import java.util.Scanner;

public class Main {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazineWords, String[] note) {

        Hashtable<String, Integer> magazine = new Hashtable<>();
        boolean notEnoughWords = false;

        // build a hashtable with all the words and counter for each one
        for(String s : magazineWords){
            if(magazine.containsKey(s)){
                magazine.put(s, magazine.get(s) + 1);
            } else {
                magazine.put(s, 1);
            }
        }

        for(String s : note){
            // if no word in a magazine then NO
            if(!magazine.containsKey(s)){
                notEnoughWords = true;
                System.out.println("No");
                break;
            }

            // decrease counter
            int counter = magazine.get(s) - 1;

            // if no counter left, remove the word or update the counter
            if(counter == 0){
                magazine.remove(s);
            }else{
                magazine.put(s, counter);
            }
        }

        if (!notEnoughWords) {
            System.out.println("Yes");
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
