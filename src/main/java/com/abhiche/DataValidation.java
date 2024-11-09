package com.abhiche;

import java.util.GregorianCalendar;

/**
 * Helper class for sanitizing user inputs
 */

public class DataValidation {

    /**
     * Tests against empty or null Strings
     */

    public static void nonEmptyString(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Null or empty string was caught!");
        }
    }

    /**
     * Validates that the entered number is between an upper and lower bound (inclusive)
     * @param num Number to test
     * @param low Lower Boundary
     * @param high Upper Boundary
     * @throws IllegalArgumentException when num is invalid
     */

    public static void between(double num, double low, double high) {
        if (num < low || num > high) {
            throw new IllegalArgumentException("Argument 'num' must be between 'low' and 'high'!");
        }
    }

    /**
     * Test that the provided number is greater than a lower boundary
     * @param num The number to test
     * @param low The lower boundary
     * @throws IllegalArgumentException when 'num' is not greater than the lower boundary.
     */

    public static void greater(double num, double low) {
        if (num < low) {
            throw new IllegalArgumentException("'num' must be greater than or equal to 'low'!");
        }
    }

    /**
     * Tests that the Dollar object is greater than or equal to zero (for setting prices)
     * @param price The Dollar object to be tested
     * @throws IllegalArgumentException when Dollar is negative.
     */

    public static void positiveMoney(Dollar price) {
        if (price.isNegative()) {
            throw new IllegalArgumentException("Dollar object cannot be negative!");
        }
    }

    /**
     * Tests that the GregorianCalendar object is not null
     */

    public static void nonEmptyDate(GregorianCalendar date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null!");
        }
    }
}