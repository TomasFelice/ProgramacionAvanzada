public class Main {
    public static void main(String[] args) {
        int imageSize = (int) (Math.random() * 10) + 1;
        System.out.println("Image size: " + imageSize + "x" + imageSize);
        int[][] squaredImage = generateSquaredImage(imageSize);

        System.out.println("Original matrix: ");
        printImage(squaredImage);

        rotate90(squaredImage);
//      rotate90_2(squaredImage);

        System.out.println(" ");
        System.out.println("Rotated matrix: ");
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

    /**
     * Solution 1. Squares method
     * @param int[][] squaredImage
     */
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

    /**
     * Solution 2. Transpose and invest rows
     * @param int[][] squaredImage
     */
    public static void rotate90_2(int[][] squaredImage) {
        transposeSquaredImage(squaredImage);

        System.out.println(" ");
        System.out.println("Transposed matrix: ");
        printImage(squaredImage);

        investRows(squaredImage);
    }

    public static void transposeSquaredImage(int[][] squaredImage) {
        int n = squaredImage.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                int aux = squaredImage[i][j];
                squaredImage[i][j] = squaredImage[n - j - 1][n - i - 1];
                squaredImage[n - j - 1][n - i - 1] = aux;
            }
        }
    }

    public static void investRows(int[][] squaredImage) {
        int n = squaredImage.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int aux = squaredImage[i][j];
                squaredImage[i][j] = squaredImage[n - i - 1][j];
                squaredImage[n - i - 1][j] = aux;
            }
        }
    }
}