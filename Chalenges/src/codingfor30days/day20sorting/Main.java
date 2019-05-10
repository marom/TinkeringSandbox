package codingfor30days.day20sorting;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        // Write Your Code Here
        int numOfSwaps = 0;

        for (int i = 0; i < a.length; i++) {

            for (int j = 0; j < a.length - 1; j++) {

                if (a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    numOfSwaps++;
                }
            }
        }

        in.close();

        System.out.println("Array is sorted in " + numOfSwaps  + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length-1]);
    }
}
