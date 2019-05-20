package codingfor30days.day26nestedlogic;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner jin = new Scanner(System.in);
        int day = jin.nextInt();
        int month = jin.nextInt();
        int year = jin.nextInt();
        int expDay = jin.nextInt();
        int expMonth = jin.nextInt();
        int yearExpected = jin.nextInt();

        int fine = 0;

        if(year > yearExpected){
            fine = 10000;
        }else if(year == yearExpected && month > expMonth){
            fine = (month - expMonth) * 500;
        }else if(year == yearExpected && month == expMonth && day > expDay){
            fine = (day - expDay) * 15;
        }

        System.out.println(fine);
    }
}
