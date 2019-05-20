package codingfor30days.day25primenumbers;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }

        for (int i = 0; i < a.length; i++) {
            isPrime(a[i]);
        }
        in.close();

    }

    public static void isPrime(int num) {

        boolean flag = false;

        if (num <= 1) {
            System.out.println("Not prime");
        } else {

            for (int i = 2; i <= num / 2; ++i) {
                if (num%i == 0) {
                    flag = true;
                    break;
                }
            }

            if (!flag){
                System.out.println("Prime");
            } else {
                System.out.println("Not prime");
            }
        }
    }


//    public static boolean isPrime(int n){
//        if(n == 1){
//            return false;
//        }
//        if(n == 2){
//            return true;
//        }
//        for (int i = 2; i*i<=n; i++) {
//            if (n % i == 0) {
//                return false;
//            }
//        }
//        return true;
//    }
}
