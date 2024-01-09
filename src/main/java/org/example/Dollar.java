package org.example;

/**
 * Dollar class for representation of USD currency amounts
 */

public class Dollar {
    private long value;

    /**
     * Build a Dollar object from a value of pennies/cents.
     * @param cents count of pennies
     */

    public Dollar(long cents) {
        this.value = cents;
    }

    /**
     * Build a Dollar object with a value of 0
     */

    public Dollar() {
        this(0);
    }

    /**
     * Build a Dollar object by passing dollar and cent amounts to the constructor.
     */

    public Dollar(int dollars, int cents) {
        this((long)dollars * 100 + cents);
    }

    /**
     * Build a Dollar object from a double
     */

    public Dollar(double amount) {
        this((long)Math.round(amount * 100.0));
    }

    /**
     * Return a double representation of the Dollar value.
     * @return double The Value of the Dollar Object.
     */

    public double asDouble() {
        return this.value / 100.0;
    }

    /**
     * Return a long representation of the Dollar value.
     * @return long The Value of the Dollar Object
     */

    public long asLong() {
        return this.value;
    }

    /**
     * Method to check if the Dollar object has a negative value.
     * @return boolean whether or not the Dollar object has a negative value
     */

    public boolean isNegative() {
        return this.value < 0;
    }

    /**
     * Negates the Dollar object's value by creating a new Dollar object with the sign reversed.
     * @return Dollar the negated Dollar value
     */

    public Dollar negate() {
        return new Dollar(-this.value);
    }

    /**
     * Overrides Object.equals() for comparing the value of two Dollar objects.
     * @param other the other Dollar object to compare against.
     * @return boolean whether or not the two Dollar objects have equal value.
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Dollar)) {
            return false;
        }
        return this.value == ((Dollar) other).asLong();
    }

    /**
     * Overrides Object.toString() for debugging purposes.
     * @return String A string representation of the Dollar object value.
     */
    @Override
    public String toString() {
        long dollars = this.value / 100;
        long cents = (long) (this.value - dollars * 100);
        return String.format("[%d Dollars, %d Cents]", dollars, cents);
    }
}