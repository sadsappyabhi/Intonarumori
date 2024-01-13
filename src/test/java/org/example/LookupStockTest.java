package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LookupStockTest {

    @Test
    public void testMatches() {
        LookupStock ls = new LookupStock(10);
        Vinyl v = new Vinyl();
        v.setQuantity(100);
        assertFalse(ls.matches(v));
        v.setQuantity(5);
        assertTrue(ls.matches(v));
    }
}