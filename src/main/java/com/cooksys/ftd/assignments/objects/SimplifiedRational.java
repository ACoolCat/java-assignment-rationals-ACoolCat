package com.cooksys.ftd.assignments.objects;


public class SimplifiedRational implements IRational {

    private int denominator;
    private int numerator;
    public int rationalValue;
    /**
     * Determines the greatest common denominator for the given values
     *
     * @param a the first value to consider
     * @param b the second value to consider
     * @return the greatest common denominator, or shared factor, of `a` and `b`
     * @throws IllegalArgumentException if a <= 0 or b < 0
     */
    public static int gcd(int a, int b) throws IllegalArgumentException {
        if(a<=0 || b<0){
            throw new IllegalArgumentException();
        }else{
            switch(a){
                case 0:
                    return b;
                default:
                    return gcd(b%a, a);
            }
        }

    }

    /**
     * Simplifies the numerator and denominator of a rational value.
     * <p>
     * For example:
     * `simplify(10, 100) = [1, 10]`
     * or:
     * `simplify(0, 10) = [0, 1]`
     *
     * @param numerator   the numerator of the rational value to simplify
     * @param denominator the denominator of the rational value to simplify
     * @return a two element array representation of the simplified numerator and denominator
     * @throws IllegalArgumentException if the given denominator is 0
     */
     static public int[] simplify(int numerator, int denominator) throws IllegalArgumentException {
        if(denominator == 0){
            throw new IllegalArgumentException();
        }else{
            int divisor = 0;

            for(int i =numerator; i>= 1; i--){
                if(numerator % 1 == 0 && denominator % i == 0){
                    divisor = i;

                }
            }
            switch(divisor){
                case 0:
                    int[] simpArray = new int[] {numerator, denominator};
                    return simpArray;
                default:
                    numerator = numerator/divisor;
                    denominator = denominator/divisor;
            }
            numerator = numerator;
            denominator = denominator;

        }
        return new int[0];
    }

    /**
     * Constructor for rational values of the type:
     * <p>
     * `numerator / denominator`
     * <p>
     * Simplification of numerator/denominator pair should occur in this method.
     * If the numerator is zero, no further simplification can be performed
     *
     * @param numerator   the numerator of the rational value
     * @param denominator the denominator of the rational value
     * @throws IllegalArgumentException if the given denominator is 0
     */
    public SimplifiedRational(int numerator, int denominator) throws IllegalArgumentException {
        if(denominator == 0){
            throw new IllegalArgumentException();
        }else{
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    /**
     * @return the numerator of this rational number
     */
    @Override
    public int getNumerator() {
        return numerator;
    }

    /**
     * @return the denominator of this rational number
     */
    @Override
    public int getDenominator() {

        return denominator;
    }

    /**
     * Specializable constructor to take advantage of shared code between Rational and SimplifiedRational
     * <p>
     * Essentially, this method allows us to implement most of IRational methods directly in the interface while
     * preserving the underlying type
     *
     * @param numerator   the numerator of the rational value to construct
     * @param denominator the denominator of the rational value to construct
     * @return the constructed rational value (specifically, a SimplifiedRational value)
     * @throws IllegalArgumentException if the given denominator is 0
     */
    @Override
    public SimplifiedRational construct(int numerator, int denominator) throws IllegalArgumentException {
        if(denominator==0){
            throw new IllegalArgumentException();
        }else{
            int rationalValue;
            rationalValue = numerator/denominator;
            this.rationalValue = rationalValue;
            return (new SimplifiedRational(numerator, denominator));
        }
    }

    /**
     * @param obj the object to check this against for equality
     * @return true if the given obj is a rational value and its
     * numerator and denominator are equal to this rational value's numerator and denominator,
     * false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj ) {
            return true;
        }else{
            return false;
        }
    }

    /**
     * If this is positive, the string should be of the form `numerator/denominator`
     * <p>
     * If this is negative, the string should be of the form `-numerator/denominator`
     *
     * @return a string representation of this rational value
     */
    @Override
    public String toString() {
        if(this.getNumerator() < 0 && this.getDenominator() < 0){
            return Math.abs(this.getNumerator()) + "/" + Math.abs(this.getDenominator());
        }else if(this.getNumerator() < 0 || this.getDenominator() < 0){
            return "-" + Math.abs(this.getNumerator()) + "/" + Math.abs(this.getDenominator());
        }else{
            return this.getNumerator() + "/" + this.getDenominator();
        }
    }
}
