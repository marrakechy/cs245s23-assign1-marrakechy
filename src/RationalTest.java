import java.math.BigInteger;

public class RationalTest {
    public static void main(String[] args) {
        Rational r1 = new Rational(new BigInteger("3"), new BigInteger("4"));
        Rational r2 = new Rational(new BigInteger("5"), new BigInteger("6"));

        System.out.println("Rational number 1: " + r1);
        System.out.println("Rational number 2: " + r2);

        Rational r3 = r1.add(r2);
        System.out.println("Result of addition: " + r3);

        Rational r4 = r1.subtract(r2);
        System.out.println("Result of subtraction: " + r4);

        Rational r5 = r1.multiply(r2);
        System.out.println("Result of multiplication: " + r5);

        Rational r6 = r1.divide(r2);
        System.out.println("Result of division: " + r6);

        System.out.println("Are r1 and r2 equal: " + r1.equals(r2));
    }
}
