package com.abhiche;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DollarTest {
    private Dollar treeFiddy;
    private Dollar zero;
    private Dollar pennies;
    private Dollar fromDouble;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        treeFiddy = new Dollar(3, 50);
        zero = new Dollar();
        pennies = new Dollar(456);
        fromDouble = new Dollar(29.99);
    }

    @Test
    public void testConstructor() {
        assertNotNull(treeFiddy);
        assertEquals(3.50, treeFiddy.asDouble());
        assertEquals(350, treeFiddy.asLong());

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
        assertEquals(3.50, treeFiddy.asDouble());
        assertEquals(0, zero.asDouble());
        assertEquals(4.56, pennies.asDouble());
        assertEquals(29.99, fromDouble.asDouble());
    }

    @Test
    void asLong() {
        assertEquals(350, treeFiddy.asLong());
        assertEquals(0, zero.asLong());
        assertEquals(456, pennies.asLong());
        assertEquals(2999, fromDouble.asLong());
    }

    @Test
    void isNegative() {
        Dollar negativeTreeFiddy = treeFiddy.negate();
        Dollar negativePennies = pennies.negate();
        Dollar negativeDouble = fromDouble.negate();

        assertFalse(treeFiddy.isNegative());
        assertFalse(pennies.isNegative());
        assertFalse(fromDouble.isNegative());

        assertTrue(negativeTreeFiddy.isNegative());
        assertTrue(negativePennies.isNegative());
        assertTrue(negativeDouble.isNegative());
    }

    @Test
    void negate() {
        assertEquals(3.50, treeFiddy.asDouble());
        Dollar negativeTreeFiddy = treeFiddy.negate();
        assertEquals(-3.50, negativeTreeFiddy.asDouble());

        assertEquals(0, zero.asDouble());
        Dollar negativeZero = zero.negate();
        assertEquals(-0, negativeZero.asDouble());

        assertEquals(4.56, pennies.asDouble());
        Dollar negativePennies = pennies.negate();
        assertEquals(-4.56, negativePennies.asDouble());

        assertEquals(29.99, fromDouble.asDouble());
        Dollar negativeDouble = fromDouble.negate();
        assertEquals(-29.99, negativeDouble.asDouble());
    }

    @Test
    void testEquals() {
        Dollar treeFiddyTwo = new Dollar(3, 50);
        assertEquals(treeFiddy.asDouble(), treeFiddyTwo.asDouble());
        assertEquals(treeFiddy.asLong(), treeFiddyTwo.asLong());
        assertEquals(treeFiddy, treeFiddyTwo);

        Dollar zeroTwo = new Dollar();
        assertEquals(zero.asDouble(), zeroTwo.asDouble());
        assertEquals(zero.asLong(), zeroTwo.asLong());
        assertEquals(zero, zeroTwo);

        Dollar penniesTwo = new Dollar(456);
        assertEquals(pennies.asDouble(), penniesTwo.asDouble());
        assertEquals(pennies.asLong(), penniesTwo.asLong());
        assertEquals(pennies, penniesTwo);

        Dollar fromDoubleTwo = new Dollar(29.99);
        assertEquals(fromDouble.asDouble(), fromDoubleTwo.asDouble());
        assertEquals(fromDouble.asLong(), fromDoubleTwo.asLong());
        assertEquals(fromDouble, fromDoubleTwo);
    }

    @Test
    void testToString() {
        assertEquals("$3.50", treeFiddy.toString());
        assertEquals("$4.56", pennies.toString());
        assertEquals("$0.00", zero.toString());
        assertEquals("$29.99", fromDouble.toString());
    }
}