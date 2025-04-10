import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbersToVerify = getNumbersToVerify();

        for (Integer number : numbersToVerify) {
            System.out.println("Number to verify: " + number);
            System.out.println("Quadratic: " + StreetNumbers.quadratic(number));
            System.out.println("Linear: " + StreetNumbers.linear(number));
            System.out.println("Constant: " + StreetNumbers.constant(number));
            System.out.println("---------------------------------------");
        }
    }

    private static ArrayList<Integer> getNumbersToVerify() {
        ArrayList<Integer> numbersToVerify = new ArrayList<>();
        numbersToVerify.add(8);
        numbersToVerify.add(100);
        numbersToVerify.add(49);
        numbersToVerify.add(50);
        numbersToVerify.add(288);
        numbersToVerify.add(287);
        numbersToVerify.add(1681);
        numbersToVerify.add(9800);
        numbersToVerify.add(57121);
        numbersToVerify.add(332928);
        numbersToVerify.add(1940449);
        numbersToVerify.add(11309768);
        numbersToVerify.add(65918161);
        return numbersToVerify;
    }
}
