package com.abhiche;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

public class CassetteTest {

    private Cassette c;
    private Dollar treefiddy;
    private GregorianCalendar hgReleaseDate;
    private GregorianCalendar vpReleaseDate;
    private String hgDesc;
    private String vpDesc;

    @BeforeEach
    public void setUp() {
        c = new Cassette();
        assertNotNull(c);
        treefiddy = new Dollar(3, 50);
        hgReleaseDate = new GregorianCalendar(2023, Calendar.SEPTEMBER, 29);
        vpReleaseDate = new GregorianCalendar(2023, Calendar.FEBRUARY, 3);
        hgDesc = "Expanding on the adventurous techniques that manifested their self-titled debut album, Chicago " +
                "improvising trio, Hearsay returns with Glossolalia.";
        vpDesc = "To oppose vulgarity is inevitably to be vulgar.";
    }

    @Test
    public void testArtist() {
        assertNull(c.getArtist());
        c.setArtist("Hearsay");
        assertEquals("Hearsay", c.getArtist());
    }

    @Test
    public void testTitle() {
        assertNull(c.getTitle());
        c.setTitle("Glossolalia");
        assertEquals("Glossolalia", c.getTitle());
    }

    @Test
    public void testProductId() {
        assertNull(c.getProductId());
        c.setProductId("AM049");
        assertEquals("AM049", c.getProductId());
    }

    @Test
    public void testPrice() {
        assertNull(c.getPrice());
        c.setPrice(treefiddy);
        assertEquals(3.50, c.getPrice().asDouble());
    }

    @Test
    public void testDescription() {
        assertNull(c.getDescription());
        c.setDescription(hgDesc);
        assertEquals(hgDesc, c.getDescription());
    }

    @Test
    public void testQuantity() {
        assertEquals(0, c.getQuantity());
        c.setQuantity(100);
        assertEquals(100, c.getQuantity());
    }


    @Test
    public void testEquals() {
        c.setArtist("Hearsay");
        c.setTitle("Glossolalia");
        c.setProductId("AM049");
        c.setPrice(treefiddy);
        c.setDescription(hgDesc);
        c.setQuantity(100);
        c.setDuration(30);
        c.setReleaseDate(hgReleaseDate);

        Cassette inv = new Cassette("Violent Pleasures", "Iron Nerve & Vanity", "DBT012", treefiddy,
                vpDesc, 32, vpReleaseDate, 28);

        Cassette d = new Cassette("Hearsay", "Glossolalia", "AM049", treefiddy, hgDesc, 100,
                hgReleaseDate, 30);

        assertNotEquals(c, inv);
        assertEquals(c, d);
    }

    @Test
    public void testDuration() {
        assertEquals("C-0", c.getDuration());
        c.setDuration(30);
        assertEquals("C-30", c.getDuration());
    }


    @Test
    public void testReleaseDate() {
        assertNull(c.getReleaseDate());
        c.setReleaseDate(hgReleaseDate);
        assertEquals(hgReleaseDate, c.getReleaseDate());
    }

    @Test
    public void testToString() {
        Cassette inv = new Cassette("Violent Pleasures", "Iron Nerve & Vanity", "DBT012", treefiddy,
                vpDesc, 32, vpReleaseDate, 28);
        assertEquals(String.format("Artist=Violent Pleasures, Title=Iron Nerve & Vanity, ProductID=DBT012, Price=$3" +
                ".50, Description=%s, QuantityOnHand=32, ReleaseDate=2023-02-03, Duration=C-28", vpDesc),
                inv.toString());
    }
}