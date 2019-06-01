package comparetriplets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    // Complete the compareTriplets function below.
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

        int aScore = 0;
        int bScore = 0;

        for (int i = 0; i < a.size(); i++) {
                if (a.get(i) > b.get(i)) {
                    aScore++;
                } else if(a.get(i) < b.get(i)) {
                    bScore++;
                }

        }
        List<Integer> result = new ArrayList<>();
        result.add(aScore);
        result.add(bScore);

        return result;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] aItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a.add(aItem);
        }

        String[] bItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> b = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int bItem = Integer.parseInt(bItems[i]);
            b.add(bItem);
        }

        List<Integer> result = compareTriplets(a, b);

        for (int i = 0; i < result.size(); i++) {

            System.out.print(result.get(i) + " ");
        }

        bufferedReader.close();
    }
}
