package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.*;

class VinylTest {
    private Vinyl v;
    private Dollar treefiddy;
    private GregorianCalendar flReleaseDate;
    private GregorianCalendar mbReleaseDate;
    private String flDesc;
    private String mbDesc;
    @BeforeEach
    void setUp() {
        v = new Vinyl();
        assertNotNull(v);
        treefiddy = new Dollar(3, 50);
        flReleaseDate = new GregorianCalendar(2023, Calendar.NOVEMBER, 2);
        mbReleaseDate = new GregorianCalendar(2023, Calendar.NOVEMBER, 17);
        flDesc = "The LoOops surf that same wave of art school dropout lysergia that seemed to push the dull end of " +
                "the eighties into the next decade. As to where You're Somebody's World travels, it probably depends " +
                "on what you're on/off, but the notion is strange, and the question mark is alive and kicking.";
        mbDesc = "Recorded live on 7th December, 1990 at JazzMarathon at De Oosterpoort, Groningen, the Netherlands";
    }

    @Test
    public void testArtist() {
        assertNotNull(v);
        v.setArtist("Fruit LoOops");
        assertEquals("Fruit LoOops", v.getArtist());
    }


    @Test
    public void testTitle() {
        assertNull(v.getTitle());
        v.setTitle("You're Somebody's World");
        assertEquals("You're Somebody's World", v.getTitle());
    }


    @Test
    public void testProductId() {
        assertNull(v.getProductId());
        v.setProductId("TL072");
        assertEquals("TL072", v.getProductId());
    }

    @Test
    public void testPrice() {
        assertNull(v.getPrice());
        v.setPrice(treefiddy);
        assertEquals(treefiddy, v.getPrice());
    }

    @Test
    public void testDescription() {
        assertNull(v.getDescription());
        v.setDescription(flDesc);
        assertEquals(flDesc, v.getDescription());
    }

    @Test
    public void testQuantity() {
        assertEquals(0, v.getQuantity());
        v.setQuantity(30);
        assertEquals(30, v.getQuantity());
    }

    @Test
    public void testReleaseDate() {
        assertNull(v.getReleaseDate());
        v.setReleaseDate(flReleaseDate);
        assertEquals(flReleaseDate, v.getReleaseDate());
    }

    @Test
    public void testRotationSpeed() {
        assertNull(v.getRotationSpeed());
        v.setRotationSpeed(Vinyl.RotationSpeed.RPM33);
        assertEquals(Vinyl.RotationSpeed.RPM33, v.getRotationSpeed());
    }

    public void testDiscSize() {
        assertNull(v.getDiscSize());
        v.setDiscSize(Vinyl.DiscSize.TWELVE);
        assertEquals(Vinyl.DiscSize.TWELVE, v.getDiscSize());
    }

    @Test
    void testEquals() {
        v.setArtist("Fruit LoOops");
        v.setTitle("You're Somebody's World");
        v.setProductId("TL072");
        v.setPrice(treefiddy);
        v.setDescription(flDesc);
        v.setQuantity(30);
        v.setReleaseDate(flReleaseDate);
        v.setRotationSpeed(Vinyl.RotationSpeed.RPM33);
        v.setDiscSize(Vinyl.DiscSize.TWELVE);

        Vinyl pmdb = new Vinyl("Derek Bailey & Paul Motian", "Duo In Concert", "fr24v", treefiddy,
                mbDesc, 100, mbReleaseDate, Vinyl.RotationSpeed.RPM33, Vinyl.DiscSize.TWELVE);

        Vinyl gv = new Vinyl("Fruit LoOops", "You're Somebody's World", "TL072", treefiddy, flDesc,
                30, flReleaseDate, Vinyl.RotationSpeed.RPM33, Vinyl.DiscSize.TWELVE);

        assertNotEquals(v, pmdb);
        assertEquals(v, gv);
    }

    @Test
    void testToString() {
        Vinyl gv = new Vinyl("Fruit LoOops", "You're Somebody's World", "TL072", treefiddy, flDesc,
                30, flReleaseDate, Vinyl.RotationSpeed.RPM33, Vinyl.DiscSize.TWELVE);
        assertEquals(String.format("Artist=Fruit LoOops, Title=You're Somebody's World, ProductID=TL072, Price=$3.50," +
                " Description=%s, QuantityOnHand=30, ReleaseDate=2023-11-02, RotationSpeed=33 1/3 RPM, DiscSize=12\""
                , flDesc), gv.toString());
    }
}