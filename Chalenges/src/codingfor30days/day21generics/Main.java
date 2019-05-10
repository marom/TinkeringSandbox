package codingfor30days.day21generics;

import java.util.Scanner;

public class Main {

    static class Printer <T> {
        public void printArray(T[] param) {
            for (T element : param) {
                System.out.println(element);
            }
        }

        /**
         *    Method Name: printArray
         *    Print each element of the generic array on a new line. Do not return anything.
         *    @param A generic array
         **/

        // Write your code here

    }


    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[] intArray = new Integer[n];
        for (int i = 0; i < n; i++) {
            intArray[i] = scanner.nextInt();
        }

        n = scanner.nextInt();
        String[] stringArray = new String[n];
        for (int i = 0; i < n; i++) {
            stringArray[i] = scanner.next();
        }

        Printer<Integer> intPrinter = new Printer<>();
        Printer<String> stringPrinter = new Printer<>();
        intPrinter.printArray( intArray  );
        stringPrinter.printArray( stringArray );
        if(Printer.class.getDeclaredMethods().length > 1){
            System.out.println("The Printer class should only have 1 method named printArray.");
        }
    }
}
