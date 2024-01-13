package org.example;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class CompactDiscTest {

    private CompactDisc cd;
    private Dollar treefiddy;
    private GregorianCalendar tefReleaseDate;
    private GregorianCalendar libReleaseDate;
    private String tefDesc;
    private String libDesc;

    @BeforeEach
    void setUp() {
        cd = new CompactDisc();
        assertNotNull(cd);
        treefiddy = new Dollar(3, 50);
        tefReleaseDate = new GregorianCalendar(2022, Calendar.OCTOBER, 9);
        libReleaseDate = new GregorianCalendar(2023, Calendar.SEPTEMBER, 29);
        tefDesc = "06, 77, 24, 43, 82, 50, 61, 15, 38, 19";
        libDesc = "Harsh Noise Cut-up artist Parasite Nurse tears ceaselessly into sonic landscapes, creating " +
                "fleeting portals of pavement saw tonalities and blinding blasts expertly delivered.";
    }

    @Test
    public void testArtist() {
        assertNull(cd.getArtist());
        cd.setArtist("T.E.F.");
        assertEquals("T.E.F.", cd.getArtist());
    }

    @Test
    public void testTitle() {
        assertNull(cd.getTitle());
        cd.setTitle("Wrought");
        assertEquals("Wrought", cd.getTitle());
    }


    @Test
    public void testProductId() {
        assertNull(cd.getProductId());
        cd.setProductId("DD70CD");
        assertEquals("DD70CD", cd.getProductId());
    }

    @Test
    public void testPrice() {
        assertNull(cd.getPrice());
        cd.setPrice(new Dollar(3, 50));
        assertEquals(3.50, cd.getPrice().asDouble());
    }
    @Test
    public void testDescription() {
        assertNull(cd.getDescription());
        cd.setDescription(tefDesc);
        assertEquals(tefDesc, cd.getDescription());
    }

    @Test
    public void testQuantity() {
        assertEquals(0, cd.getQuantity());
        cd.setQuantity(32);
        assertEquals(32, cd.getQuantity());
    }

    @Test
    public void testReleaseDate() {
        assertNull(cd.getReleaseDate());
        cd.setReleaseDate(tefReleaseDate);
        assertEquals(tefReleaseDate, cd.getReleaseDate());
    }

    @Test
    void testEquals() {
        cd.setArtist("T.E.F.");
        cd.setTitle("Wrought");
        cd.setProductId("DD70CD");
        cd.setPrice(treefiddy);
        cd.setDescription(tefDesc);
        cd.setQuantity(14);
        cd.setReleaseDate(tefReleaseDate);
        cd.setDiscType(CompactDisc.DiscType.CD120MM);

        CompactDisc pnlib = new CompactDisc("Parasite Nurse", "Life is Beautiful", "OXEN082", treefiddy,
                libDesc, 14, libReleaseDate, CompactDisc.DiscType.CD120MM);

        CompactDisc d = new CompactDisc("T.E.F.", "Wrought", "DD70CD", treefiddy, tefDesc, 14,
                tefReleaseDate, CompactDisc.DiscType.CD120MM);

        assertNotEquals(cd, pnlib);
        assertEquals(cd, d);
    }

    @Test
    public void testToString() {
        CompactDisc pnlib = new CompactDisc("Parasite Nurse", "Life is Beautiful", "OXEN082", treefiddy,
                libDesc, 14, libReleaseDate, CompactDisc.DiscType.CD120MM);
        assertEquals(String.format("Artist=Parasite Nurse, Title=Life is Beautiful, ProductID=OXEN082, Price=$3.50, " +
                        "Description=%s, QuantityOnHand=14, ReleaseDate=2023-09-29, DiscType=120mm CD",
                        pnlib.getDescription()), pnlib.toString());
    }

    @Test
    void getDiscType() {
        assertNull(cd.getDiscType());
        cd.setDiscType(CompactDisc.DiscType.CD120MM);
        assertEquals(CompactDisc.DiscType.CD120MM, cd.getDiscType());
    }
}