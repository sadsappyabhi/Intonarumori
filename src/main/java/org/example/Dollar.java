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
        this(dollars * 100 + cents);
    }

    /**
     * Build a Dollar object from a double
     */

    public Dollar(double amount) {
        this.value = ()
    }
}