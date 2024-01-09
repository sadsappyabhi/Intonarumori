package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DollarTest {
    private Dollar treefiddy;
    private Dollar zero;
    private Dollar pennies;
    private Dollar fromDouble;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        treefiddy = new Dollar(3, 50);
        zero = new Dollar();
        pennies = new Dollar(456);
        fromDouble = new Dollar(29.99);
    }

    @Test
    public void testConstructor() {
        assertNotNull(treefiddy);
        assertEquals(3.50, treefiddy.asDouble());
        assertEquals(350, treefiddy.asLong());

        assertNotNull(zero);
        assertEquals(0, zero.asLong());
        assertEquals(0, zero.asDouble());

        assertNotNull(pennies);
        assertEquals(4.56, pennies.asDouble());
        assertEquals(456, pennies.asLong());

        assertNotNull(fromDouble);
        assertEquals(29.99, fromDouble.asDouble());
        assertEquals(2999, fromDouble.asLong());
    }
    @Test
    void asDouble() {
    }

    @Test
    void asLong() {
    }

    @Test
    void isNegative() {
    }

    @org.junit.jupiter.api.Test
    void negate() {
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
    }

    @org.junit.jupiter.api.Test
    void testToString() {
    }
}