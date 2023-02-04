import java.math.BigInteger;

public class Rational {
    private BigInteger numerator;
    protected BigInteger denominator;

    public Rational() {
        this.numerator = BigInteger.ZERO;
        this.denominator = BigInteger.ONE;
    }

    public Rational(BigInteger numerator, BigInteger denominator) {
        if (denominator.equals(BigInteger.ZERO))
        {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }

        BigInteger gcd = numerator.gcd(denominator);

        this.numerator = numerator.divide(gcd).multiply(BigInteger.valueOf(denominator.signum()));
        this.denominator = denominator.divide(gcd).abs();
    }


}

