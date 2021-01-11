package com.cooksys.ftd.assignments.objects;


public class Rational implements IRational {

    private int numerator;

    private int denominator;

    private int rationalValue;
    /**
     * Constructor for rational values of the type:
     * <p>
     * `numerator / denominator`
     * <p>
     * No simplification of the numerator/denominator pair should occur in this method.
     *
     * @param numerator   the numerator of the rational value
     * @param denominator the denominator of the rational value
     * @throws IllegalArgumentException if the given denominator is 0
     */
    public Rational(int numerator, int denominator) throws IllegalArgumentException {
        if(denominator == 0){
            throw new IllegalArgumentException();
        }else{
            this.numerator = numerator;
            this.denominator = denominator;
//            getNumerator();
//            getDenominator();
//            construct(numerator, denominator);
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
     * @param numerator the numerator of the rational value to construct
     * @param denominator the denominator of the rational value to construct
     * @return the constructed rational value
     * @throws IllegalArgumentException if the given denominator is 0
     */
    @Override
    public Rational construct(int numerator, int denominator) throws IllegalArgumentException {
        switch(denominator){
            case 0:
                throw new IllegalArgumentException();
            default:
                int rationalValue;
                rationalValue = numerator/denominator;
                this.rationalValue = rationalValue;
                this.numerator = numerator;
                this.denominator = denominator;
                return (new Rational(numerator, denominator));
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
