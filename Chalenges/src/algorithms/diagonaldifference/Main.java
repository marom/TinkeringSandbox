package algorithms.diagonaldifference;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    // Complete the diagonalDifference function below.
    static int diagonalDifference(int[][] arr) {
        int row=0;
        int column=arr[0].length - 1;
        int solution = 0;
        for(int index=0;index<arr.length;index++){
            solution -= arr[row][row] - arr[row++][column--];
        }
        return Math.abs(solution);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < n; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = diagonalDifference(arr);

        System.out.println(result);

        scanner.close();
    }

}

