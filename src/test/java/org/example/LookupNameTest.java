package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LookupNameTest {
    private LookupName ln;
    @BeforeEach
    void setUp() {
        ln = new  LookupName("Life is Beautiful");
    }

    @Test
    public void testMatches() {
        assertNotNull(ln);
        CompactDisc lib = new CompactDisc();
        lib.setTitle("Life is Beautiful");
        assertTrue(ln.matches(lib));
        CompactDisc wrought = new CompactDisc();
        wrought.setTitle("Wrought");
        assertFalse(ln.matches(wrought));
    }

    @Test
    public void testNull() {
        LookupName lookup = new LookupName(null);
        CompactDisc nullCd = new CompactDisc();
        CompactDisc lib = new CompactDisc();
        lib.setTitle("Life is Beautiful");
        assertFalse(lookup.matches(lib));
        assertTrue(lookup.matches(nullCd));
        assertNull(nullCd.getTitle());
    }

    @Test
    public void testMerch() {
        LookupName lookup = new LookupName(null);
        Zine nw = new Zine();
        Zine nf = new Zine();
        assertTrue(lookup.matches(nw));
        assertTrue(lookup.matches(nf));
        nw.setName("Noise Widow");
        assertFalse(lookup.matches(nw));
        LookupName lookupNf = new LookupName("New Forces");
        nf.setName("New Forces");
        assertTrue(lookupNf.matches(nf));
    }

    // TODO: Update this test and LookupName.matches() method AFTER creating clothing product classes as the logic
    //  will change in order to achieve 100% coverage.
    @Test
    public void testInvalidProduct() {
        assertNotNull(ln);
        CompactDisc lib = new CompactDisc();
        lib.setTitle("Life is Beautiful");
        String libTitle = "Life is Beautiful";
    }
}