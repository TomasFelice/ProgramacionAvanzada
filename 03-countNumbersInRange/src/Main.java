public class Main {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        int rangeMin = 15;
        int rangeMax = 35;

        int iterativeSolutionResult = iterativeSolution(numbers, rangeMin, rangeMax);
        int recursiveSolutionResult = recursiveSolution(numbers, rangeMin, rangeMax, 0);

        System.out.println("Iterative solution result: " + iterativeSolutionResult);
        System.out.println("Recursive solution result: " + recursiveSolutionResult);
    }

    public static int iterativeSolution(int[] numbers, int rangeMin, int rangeMax) {
        int count = 0;

        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] <= rangeMax && numbers[i] >= rangeMin) {
                count++;
            }
        }

        return count;
    }

    public static int recursiveSolution(int[] numbers, int rangeMin, int rangeMax, int index) {
        if(index >= numbers.length) {
            return 0;
        }

        if(numbers[index] <= rangeMax && numbers[index] >= rangeMin) {
            return 1 + recursiveSolution(numbers, rangeMin, rangeMax, index + 1);
        }

        return recursiveSolution(numbers, rangeMin, rangeMax, index + 1);
    }
}
