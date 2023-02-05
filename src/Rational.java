import java.math.BigInteger;
import java.util.Scanner;

public class Rational {
    private BigInteger numerator;
    protected BigInteger denominator;

    public Rational() {
        this.numerator = BigInteger.ZERO;
        this.denominator = BigInteger.ONE;
    }

    public Rational(BigInteger numerator, BigInteger denominator) {
        if (denominator.equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }

        BigInteger gcd = numerator.gcd(denominator);
        this.numerator = numerator.divide(gcd).multiply(BigInteger.valueOf(denominator.signum()));
        this.denominator = denominator.divide(gcd).abs();
    }

    public BigInteger getNumerator() {
        return numerator;
    }

    public void setNumerator(BigInteger numerator) {
        this.numerator = numerator;
    }

    public BigInteger getDenominator() {
        return denominator;
    }

    public void setDenominator(BigInteger denominator) {
        if (denominator.equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        this.denominator = denominator;
    }

    private void reduce() {
        BigInteger gcd = numerator.gcd(denominator);
        numerator = numerator.divide(gcd);
        denominator = denominator.divide(gcd);
    }

    public Rational add(Rational other) {
        BigInteger newNumerator = this.numerator.multiply(other.denominator).add(other.numerator.multiply(this.denominator));
        BigInteger newDenominator = this.denominator.multiply(other.denominator);
        Rational result = new Rational(newNumerator, newDenominator);
        result.reduce();
        return result;
    }

    public Rational subtract(Rational other) {
        BigInteger newNumerator = this.numerator.multiply(other.denominator).subtract(other.numerator.multiply(this.denominator));
        BigInteger newDenominator = this.denominator.multiply(other.denominator);
        Rational result = new Rational(newNumerator, newDenominator);
        result.reduce();
        return result;
    }

    public Rational multiply(Rational other) {
        BigInteger newNumerator = this.numerator.multiply(other.numerator);
        BigInteger newDenominator = this.denominator.multiply(other.denominator);
        Rational result = new Rational(newNumerator, newDenominator);
        result.reduce();
        return result;
    }

    public Rational divide(Rational other) {
        BigInteger newNumerator = this.numerator.multiply(other.denominator);
        BigInteger newDenominator = this.denominator.multiply(other.numerator);
        Rational result = new Rational(newNumerator, newDenominator);
        result.reduce();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rational rational = (Rational) o;
        return numerator.equals(rational.numerator) &&
                denominator.equals(rational.denominator);
    }

    @Override
    public String toString() {
        if (denominator.equals(BigInteger.ONE)) {
            return numerator.toString();
        }

        BigInteger wholeNumber = numerator.divide(denominator);
        if (wholeNumber.equals(BigInteger.ZERO)) {
            return numerator + "/" + denominator;
        } else {
            BigInteger remainder = numerator.mod(denominator);
            return wholeNumber + " and " + remainder + "/" + denominator;
        }
    }


    }

