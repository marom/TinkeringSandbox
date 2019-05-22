package arraysleftrotation;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int[] result = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            result[(i + (a.length - d)) % a.length] = a[i];
        }
            return result;
    }

    static int[] rotLeftOneByOne(int[] a, int d) {
        for (int i = 0; i < d; i++) {
            leftRotatebyOne(a);
        }
        return a;
    }

    static void leftRotatebyOne(int arr[])
    {
        int i, temp;
        temp = arr[0];
        for (i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[i] = temp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);
        System.out.println(result);

        System.out.println("=======");

        int[] rotLeftOneByOne = rotLeftOneByOne(a, d);
        System.out.println(rotLeftOneByOne);
        scanner.close();
    }

}
