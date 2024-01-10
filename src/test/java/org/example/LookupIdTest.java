package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LookupIdTest {

    private LookupId li;

    @BeforeEach
    public void setUp() {
        li = new LookupId("10");
    }
    @Test
    public void testConstructor() {
        assertNotNull(li);
    }
    @Test
    void matches() {

    }

    @Test
    void testMatches() {
    }
}