public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int result = sum(array);

        System.out.println(result);
    }

    public static int sum(int[] array) {
        return sum(array, 0, array.length-1);
    }

    public static int sum(int[] array, int lo, int hi) {
        if(lo == hi) {
            return array[hi];
        }

        if(hi - lo == 1) {
            return array[lo] + array[hi];
        }

        int mid = (lo + hi) / 2;

        return sum(array, lo, mid) + sum(array, mid + 1, hi);
    }
}
