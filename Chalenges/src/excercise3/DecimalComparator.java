package excercise3;

import java.math.BigDecimal;

public class DecimalComparator{

    public static void main(String[] args) {
        boolean result = areEqualByThreeDecimalPlaces(-3.1756, -3.175);
        System.out.println(result);
    }
    public static boolean areEqualByThreeDecimalPlaces(double num1, double num2) {

        BigDecimal numbd1 = new BigDecimal(num1);
        numbd1.setScale(3, BigDecimal.ROUND_HALF_DOWN);

        BigDecimal numbd2 = new BigDecimal(num2);
        numbd2.setScale(3, BigDecimal.ROUND_HALF_DOWN);

        if (numbd1 == numbd2) {
            return true;
        }
        return false;
    }

}
