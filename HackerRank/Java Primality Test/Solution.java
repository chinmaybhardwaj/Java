import java.math.BigInteger;
import java.util.Scanner;

class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BigInteger n = scanner.nextBigInteger();
        System.out.println(n.isProbablePrime(100) ? "prime" : "not prime");
        scanner.close();
    }
}
