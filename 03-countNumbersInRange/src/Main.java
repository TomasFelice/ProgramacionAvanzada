public class Main {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        int rangeMin = 15;
        int rangeMax = 35;

        int iterativeSolutionResult = iterativeSolution(numbers, rangeMin, rangeMax);
        int recursiveSolutionResult = recursiveSolution(numbers, rangeMin, rangeMax, 0);
        int iterativeSolutionResult2 = iterativeSolution2(numbers, rangeMin, rangeMax);

        System.out.println("Iterative solution result: " + iterativeSolutionResult);
        System.out.println("Recursive solution result: " + recursiveSolutionResult);
        System.out.println("Iterative solution result 2: " + iterativeSolutionResult2);
    }

    /**
     * Parte 1 - Solución iterativa.
     * @param numbers int[]
     * @param rangeMin int
     * @param rangeMax int
     * @return int
     */
    public static int iterativeSolution(int[] numbers, int rangeMin, int rangeMax) {
        int count = 0;

        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] <= rangeMax && numbers[i] >= rangeMin) {
                count++;
            }
        }

        return count;
    }

    /**
     * Parte 1 - Solución recursiva.
     * @param numbers int[]
     * @param rangeMin int
     * @param rangeMax int
     * @param index int
     * @return int
     */
    public static int recursiveSolution(int[] numbers, int rangeMin, int rangeMax, int index) {
        if(index >= numbers.length) {
            return 0;
        }

        if(numbers[index] <= rangeMax && numbers[index] >= rangeMin) {
            return 1 + recursiveSolution(numbers, rangeMin, rangeMax, index + 1);
        }

        return recursiveSolution(numbers, rangeMin, rangeMax, index + 1);
    }

    /**
     * Parte 2 - Solución iterativa.
     * @param numbers int[]
     * @param rangeMin int
     * @param rangeMax int
     * @return int
     */
    public static int iterativeSolution2(int[] numbers, int rangeMin, int rangeMax) {
        int indexMinElement = findInferiorLimit(numbers, rangeMin);
        int indexMaxElement = findSuperiorLimit(numbers, rangeMax);

        return indexMaxElement - indexMinElement;
    }

    /**
     * Busca el indice de primer elemento >= al limite inferior
     * @param numbers int[]
     * @param number int
     * @return int
     */
    public static int findInferiorLimit(int[] numbers, int number) {
        int index = numbers.length;
        int firstIndex = 0;
        int lastIndex = numbers.length - 1;

        while (firstIndex <= lastIndex) {
            int middleIndex = firstIndex + (lastIndex - firstIndex) / 2;
            if (numbers[middleIndex] < number) {
                firstIndex = middleIndex + 1;
            } else {
                lastIndex = middleIndex - 1;
                index = middleIndex;
            }
        }

        return index;
    }

    /**
     * Busca el indice de primer elemento > al limite superior
     * @param numbers int[]
     * @param number int
     * @return int
     */
    public static int findSuperiorLimit(int[] numbers, int number) {
        int index = numbers.length;
        int firstIndex = 0;
        int lastIndex = numbers.length - 1;

        while(firstIndex <= lastIndex) {
            int middleIndex = firstIndex + (lastIndex - firstIndex) / 2;
            if(numbers[middleIndex] > number) {
                lastIndex = middleIndex - 1;
                index = middleIndex;
            } else {
                firstIndex = middleIndex + 1;
            }
        }

        return index;
    }

    public static int recursiveSolution2(int[] numbers, int rangeMin, int rangeMax) {
        // TODO
        return -1;
    }
}
