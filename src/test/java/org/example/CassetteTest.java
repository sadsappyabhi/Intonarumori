package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class CassetteTest {

    private Cassette c;

    @BeforeEach
    void setUp() {
        c = new Cassette();
        assertNotNull(c);
    }

    @Test
    void testArtist() {
        assertNull(c.getArtist());
        c.setArtist("Hearsay");
        assertEquals("Hearsay", c.getArtist());
    }

    @Test
    void testTitle() {
        assertNull(c.getTitle());
        c.setTitle("Glossolalia");
        assertEquals("Glossolalia", c.getTitle());
    }

    @Test
    void testProductId() {
        assertNull(c.getProductId());
        c.setProductId("AM049");
        assertEquals("AM049", c.getProductId());
    }

    @Test
    void testPrice() {
        assertNull(c.getPrice());
        Dollar treefiddy = new Dollar(3,50);
        c.setPrice(treefiddy);
        assertEquals(3.50, c.getPrice().asDouble());
    }

    @Test
    void testDescription() {
        assertNull(c.getDescription());
        c.setDescription("Expanding on the adventurous techniques that manifested their self-titled debut album, " +
                "Chicago improvising trio, Hearsay returns with Glossolalia.");
        assertEquals("Expanding on the adventurous techniques that manifested their self-titled debut " +
                "album, Chicago improvising trio, Hearsay returns with Glossolalia.", c.getDescription());
    }

    @Test
    void testQuantity() {
        assertEquals(0, c.getQuantity());
        c.setQuantity(100);
        assertEquals(100, c.getQuantity());
    }


    @Test
    void testEquals() {
        Dollar treefiddy = new Dollar(3, 50);
        GregorianCalendar hgrd = new GregorianCalendar(2023, GregorianCalendar.SEPTEMBER, 29);
        c.setArtist("Hearsay");
        c.setTitle("Glossolalia");
        c.setProductId("AM049");
        c.setPrice(treefiddy);
        c.setDescription("High-bias cassette tape with artwork by Jacob van Loon.");
        c.setQuantity(100);
        c.setDuration(30);
        c.setReleaseDate(hgrd);

        GregorianCalendar vprd = new GregorianCalendar(2023, Calendar.FEBRUARY, 3);
        Cassette inv = new Cassette("Violent Pleasures", "Iron Nerve & Vanity", "DBT012", treefiddy, "To oppose " +
                "vulgarity is inevitably to be vulgar.", 32, 28, vprd);

        Cassette d = new Cassette("Hearsay", "Glossolalia", "AM049", treefiddy, "High-bias cassette tape with artwork" +
                " by Jacob van Loon.", 100, 30, hgrd);

        assertNotEquals(c, inv);
        assertEquals(c, d);
    }

    @Test
    void testDuration() {
        assertEquals("C-0", c.getDuration());
        c.setDuration(30);
        assertEquals("C-30", c.getDuration());
    }


    @Test
    void testReleaseDate() {
        GregorianCalendar hgrd = new GregorianCalendar(2023, Calendar.SEPTEMBER, 29);
        assertNull(c.getReleaseDate());
        c.setReleaseDate(hgrd);
        assertEquals(hgrd, c.getReleaseDate());
    }

    @Test
    void testToString() {
        GregorianCalendar vprd = new GregorianCalendar(2023, Calendar.FEBRUARY, 3);
        Dollar treefiddy = new Dollar(3, 50);
        Cassette inv = new Cassette("Violent Pleasures", "Iron Nerve & Vanity", "DBT012", treefiddy, "To oppose " +
                "vulgarity is inevitably to be vulgar.", 32, 28, vprd);
        assertEquals("Cassette[Artist=Violent Pleasures, Title=Iron Nerve & Vanity, ProductID=DBT012, Price=$3.50, " +
                "Description=To oppose vulgarity is inevitably to be vulgar., QuantityOnHand=32, Duration=C-28, " +
                "ReleaseDate=2023-02-03", inv.toString());
    }
}