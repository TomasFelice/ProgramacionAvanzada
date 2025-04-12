public class Main {
    public static void main(String[] args) {
        int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };

        printArray(array);

        bubbleSort(array);

        printArray(array);
    }

    public static void printArray(int[] array) {
        System.out.print("[");
        for(int i = 0; i < array.length; i++) {
            System.out.print(" "+array[i]);
        }
        System.out.println(" ]");
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int aux = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = aux;
                }
            }
        }
    }

    /*
     Análisis del algoritmo:
     - https://bottlenose-isthmus-e2d.notion.site/An-lisis-de-Algoritmos-Ordenamiento-por-Burbujeo-1d34afc222ba80fdbe4fffde410263b7
    */
}
