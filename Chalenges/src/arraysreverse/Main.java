package arraysreverse;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    // Complete the reverseArray function below.
    static int[] reverseArray(int[] a) {

        int[] temp = new int[a.length];

        int j = a.length;
        for (int i = 0; i < a.length; i++) {
            temp[j - 1] = a[i];
            j = j - 1;
        }
        return temp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int arrCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[arrCount];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] res = reverseArray(arr);

        for (int i : res) {
            System.out.print(i + " ");
        }

        scanner.close();
    }
}
