import java.math.BigInteger;

public class StreetNumbers {
    public static int quadratic(int maxHouseNumber) {
        BigInteger initialHouse = BigInteger.valueOf(maxHouseNumber / 2);
        BigInteger actualHouse = initialHouse;
        BigInteger leftHouseNumbersSum = BigInteger.valueOf(0);
        BigInteger rightHouseNumbersSum = BigInteger.valueOf(0);

        while (leftHouseNumbersSum.compareTo(rightHouseNumbersSum) < 0 || actualHouse.equals(initialHouse)) {
            leftHouseNumbersSum = BigInteger.valueOf(0);
            rightHouseNumbersSum = BigInteger.valueOf(0);
            for (BigInteger i = BigInteger.ONE; i.compareTo(actualHouse) < 0; i = i.add(BigInteger.ONE)) {
                leftHouseNumbersSum = leftHouseNumbersSum.add(i);
            }

            for (BigInteger i = actualHouse.add(BigInteger.ONE); i.compareTo(BigInteger.valueOf(maxHouseNumber)) <= 0; i = i.add(BigInteger.ONE)) {
                rightHouseNumbersSum = rightHouseNumbersSum.add(i);
            }

            if (leftHouseNumbersSum.equals(rightHouseNumbersSum)) {
                return actualHouse.intValue();
            }

            actualHouse = actualHouse.add(BigInteger.ONE);
        }

        return -1;
    }

    public static int linear(int maxHouseNumber) {
        int actualHouse = maxHouseNumber / 2;
        BigInteger maxHouseFormulaChecker = BigInteger.valueOf((long) (Math.pow(maxHouseNumber, 2) + maxHouseNumber));
        BigInteger actualHouseFormulaChecker = BigInteger.ZERO;
        while(actualHouseFormulaChecker.compareTo(maxHouseFormulaChecker) < 0) {
            actualHouseFormulaChecker = BigInteger.valueOf(2L * (long) Math.pow(actualHouse, 2));

            if(maxHouseFormulaChecker.equals(actualHouseFormulaChecker)) {
                return actualHouse;
            }

            actualHouse++;
        }

        return -1;
    }



    public static int constant(int maxHouseNumber) {
        double result = Math.sqrt( ((double) maxHouseNumber /2) * (maxHouseNumber+1) );

        if (result == (int) result) {
            return (int) result;
        }

        return -1;
    }
}