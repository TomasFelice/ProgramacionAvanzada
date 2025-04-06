//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int imageSize = 4;
        int[][] squaredImage = generateSquaredImage(imageSize);
        printImage(squaredImage);

        rotate90(squaredImage);

        System.out.println(" ");
        printImage(squaredImage);
    }

    public static int[][] generateSquaredImage(int imageSize) {
        int[][] image = new int[imageSize][imageSize];
        for (int i = 0; i < imageSize; i++) {
            for (int j = 0; j < imageSize; j++) {
                image[i][j] = (int) (Math.random() * 10);
            }
        }

        return image;
    }

    public static void printImage(int[][] squaredImage) {
        for (int[] row : squaredImage) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void rotate90(int[][] squaredImage) {
        int n = squaredImage.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int aux = squaredImage[i][j];
                squaredImage[i][j] = squaredImage[n - j - 1][i];
                squaredImage[n - j - 1][i] = squaredImage[n - i - 1][n - j - 1];
                squaredImage[n - i - 1][n - j - 1] = squaredImage[j][n - i - 1];
                squaredImage[j][n - i - 1] = aux;

            }
        }
    }
}