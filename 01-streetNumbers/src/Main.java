public class Main {
    public static void main(String[] args) {
        int numberToVerify = 8;
        System.out.println("Quadratic: " + StreetNumbers.quadratic(numberToVerify));
        System.out.println("Linear: " + StreetNumbers.linear(numberToVerify));
        System.out.println("Constant: " + StreetNumbers.constant(numberToVerify));
    }
}
