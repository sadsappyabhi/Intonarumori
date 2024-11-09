package com.abhiche;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataValidationTest {
    @Test
    public void testNonEmptyDate()
    {
        boolean isCaught = false;
        try
        {
            DataValidation.nonEmptyDate(null);
        }
        catch (Exception e)
        {
            isCaught = true;
        }
        assertTrue(isCaught, "Hint: A null date should throw an exception");

    }

    @Test
    public void testNullString() {
        boolean isCaught = false;
        try {
            DataValidation.nonEmptyString(null);
        }
        catch (Exception e) {
            isCaught = true;
        }
        assertTrue(isCaught, "Hint: a null string should throw an exception");
    }

    @Test
    public void testEmptyString() {
        boolean isCaught = false;
        try {
            DataValidation.nonEmptyString("");
        }
        catch (Exception e) {
            isCaught = true;
        }
        assertTrue(isCaught, "Hint: an empty String should throw an exception");
    }

    @Test
    public void testBetweenInclusive() {
        boolean isCaught = false;
        try {
            DataValidation.between(-5, 0, 10    );
        }
        catch (Exception e) {
            isCaught = true;
        }
        assertTrue(isCaught, "Hint: Invalid number arguments should throw an exception");
    }

    @Test
    public void testGreater() {
        boolean isCaught = false;
        try {
            DataValidation.greater(5, 10);
        }
        catch (Exception e) {
            isCaught = true;
        }
        assertTrue(isCaught, "Hint: Invalid number arguments should throw an exception");
    }

    @Test
    public void testNonNegativeMoney() {
        boolean isCaught = false;
        try {
            DataValidation.positiveMoney(new Dollar(-100));
        }
        catch (Exception e) {
            isCaught = true;
        }
        assertTrue(isCaught, "Hint: Negative dollar amounts should throw an exception");
    }
}