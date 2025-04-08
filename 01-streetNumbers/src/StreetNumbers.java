public class StreetNumbers {
    public static int quadratic(int maxHouseNumber) {
        int actualHouse = maxHouseNumber / 2;
        int leftHouseNumbersSum = 0;
        int rightHouseNumbersSum = 0;

        while (leftHouseNumbersSum < rightHouseNumbersSum || actualHouse == maxHouseNumber / 2) {
            leftHouseNumbersSum = 0;
            rightHouseNumbersSum = 0;
            for (int i = 1; i < actualHouse; i++) {
                leftHouseNumbersSum += i;
            }

            for (int i = actualHouse + 1; i <= maxHouseNumber; i++) {
                rightHouseNumbersSum += i;
            }

            if (leftHouseNumbersSum == rightHouseNumbersSum) {
                return actualHouse;
            }

            actualHouse++;
        }

        return -1;
    }

    public static int linear(int maxHouseNumber) {
        int actualHouse = maxHouseNumber / 2;
        int maxHouseFormulaChecker = (int) Math.pow(maxHouseNumber, 2) + maxHouseNumber;
        int actualHouseFormulaChecker = 0;
        while(actualHouseFormulaChecker < maxHouseFormulaChecker) {
            actualHouseFormulaChecker = 2 * (int) Math.pow(actualHouse, 2);

            if(maxHouseFormulaChecker == actualHouseFormulaChecker ) {
                return actualHouse;
            }

            actualHouse++;
        }

        return -1;
    }



    public static int constant(int maxHouseNumber) {
        return -1;
    }
}