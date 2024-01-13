package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZineTest {
    private Zine z;
    private Dollar treefiddy;
    private String noiseWidow5Desc;
    private String newForcesDesc;
    @BeforeEach
    void setUp() {
        z = new Zine();
        assertNotNull(z);
        treefiddy = new Dollar(3, 50);
        noiseWidow5Desc = "Interviews with Charmaine Lee, John Collins McCormick, and Donna Parker. Noise Body " +
                "Language Demystified. Reviews. Noise kittens. Fun pages. Various jokes.";
        newForcesDesc = "The tenth issue of the New Forces zine. Interviews with Mass Marriage and Thousands of Dead " +
                "Gods. Obsessive listener’s guide to blackened drone masters Robedoor. Inane ramblings about heavy metal music. Reviews, pictures, noise ephemera.";
    }

    @Test
    public void testName() {
        assertNull(z.getName());
        z.setName("Noise Widow");
        assertEquals("Noise Widow", z.getName());
    }

    @Test
    public void testProductId() {
        assertNull(z.getProductId());
        z.setProductId("69243");
        assertEquals("69243", z.getProductId());
    }

    @Test
    public void testPrice() {
        assertNull(z.getPrice());
        z.setPrice(treefiddy);
        assertEquals(treefiddy, z.getPrice());
    }

    @Test
    public void testDescription() {
        assertNull(z.getDescription());
        z.setDescription(noiseWidow5Desc);
    }

    @Test
    public void testQuantity() {
        assertEquals(0, z.getQuantity());
        z.setQuantity(24);
        assertEquals(24, z.getQuantity());
    }

    @Test
    public void testIssueIdentifier() {
        assertNull(z.getIssueIdentifier());
        z.setIssueIdentifier("Vol. 5, Winter 2021");
        assertEquals("Vol. 5, Winter 2021", z.getIssueIdentifier());
    }

    @Test
    public void testEquals() {
        z.setName("Noise Widow");
        z.setProductId("69243");
        z.setPrice(treefiddy);
        z.setDescription(noiseWidow5Desc);
        z.setQuantity(16);
        z.setIssueIdentifier("Vol. 5, Winter 2021");

        Zine nf = new Zine("New Forces", "8928", treefiddy, newForcesDesc, 4, "Issue 10");
        Zine nw = new Zine("Noise Widow", "69243", treefiddy, noiseWidow5Desc, 16, "Vol. 5, Winter 2021");

        assertNotEquals(z, nf);
        assertEquals(z, nw);
    }

    @Test
    public void testToString() {
        Zine nf = new Zine("New Forces", "8928", treefiddy, newForcesDesc, 4, "Issue 10");
        assertEquals(String.format("Name=New Forces, ProductID=8928, Price=$3.50, Description=%s, " +
                                "QuantityOnHand=%d, IssueIdentifier=%s"
                , nf.getDescription(), nf.getQuantity(), nf.getIssueIdentifier()),
                nf.toString());
    }
}