package com.abhiche;

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
    public void testMatches() {
        assertNotNull(li);
        GiftCard gc = new GiftCard();
        gc.setProductId("11");
        assertFalse(li.matches(gc));
        gc.setProductId("10");
        assertTrue(li.matches(gc));
    }

    @Test
    public void testNull() {
        assertNotNull(li);
        GiftCard gcNull = new GiftCard();
        GiftCard gcReal = new GiftCard();
        assertNull(gcNull.getProductId());
        gcReal.setProductId("10");
        assertNotNull(gcReal.getProductId());
        assertFalse(li.matches(gcNull));
        assertTrue(li.matches(gcReal));
    }

    @Test
    public void testQuery() {
        Product xyz = new Cassette();
        Lookup query = new LookupId("This is a cassette tape");
        assertFalse(query.matches(xyz));
        Lookup query2 = new LookupId(null);
        assertTrue(query2.matches(xyz));
    }
}