package cutthebamboo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    /*
     * Complete the 'cutBamboo' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY lengths as parameter.
     */

    public static List<Integer> cutBamboo(List<Integer> lengths) {

        List<Integer> piecesAtStartOfRound = new ArrayList<>();

       while (lengths.size() > 0) {

            // count pieces of bamboo
            int pieces = lengths.size();

            piecesAtStartOfRound.add(pieces);

            // sort list
            Collections.sort(lengths);

            // find the shortest piece of bamboo
            int shortest = lengths.get(0);

            // discard any piece of that size
            for (int i = 0; i < lengths.size(); i++) {
                if (lengths.get(i) == shortest) {
                    lengths.remove(i);
                    i--;
                } else {
                    int piece = lengths.get(i);
                    piece = piece - shortest;
                    lengths.set(i, piece);
                }
            }

        }
        return piecesAtStartOfRound;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int arrCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[arrCount];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        List<Integer> lengths = new ArrayList<>();
        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            lengths.add(arrItem);
        }

        List<Integer> result = cutBamboo(lengths);

        for (Integer i : result) {
            System.out.println(i);
        }
    }
}
