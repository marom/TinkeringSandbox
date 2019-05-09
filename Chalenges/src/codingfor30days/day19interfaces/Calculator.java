package codingfor30days.day19interfaces;

public class Calculator implements AdvancedArithmetic {

    public int divisorSum(int n) {

        if (n==1) {
            return n;
        } else {
            int divisiorsSum = 1;

            for (int i = 2; i <= n / 2; i++) {
                if (n % i == 0) {
                    divisiorsSum = divisiorsSum + i;
                }
            }
            return divisiorsSum + n;
        }
    }
}
