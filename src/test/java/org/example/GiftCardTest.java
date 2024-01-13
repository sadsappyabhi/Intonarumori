package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GiftCardTest {
    private GiftCard gc;
    private Dollar treefiddy;
    private Dollar ten;
    private String sdDescription;
    @BeforeEach
    void setUp() {
        gc = new GiftCard();
        treefiddy = new Dollar(3, 50);
        sdDescription = "Select a store credit amount to be used on any items available in our physical store or online" +
                ". After purchase, we create a digital record of your store credit amount and update the amount as it is used.";
        ten = new Dollar(10, 0);
    }

    @Test
    public void testName() {
        assertNull(gc.getName());
        gc.setName("Store Credit");
        assertEquals("Store Credit", gc.getName());
    }

    @Test
    public void testProductId() {
        assertNull(gc.getProductId());
        gc.setProductId("34756");
        assertEquals("34756", gc.getProductId());
    }

    @Test
    public void testPrice() {
        assertNull(gc.getPrice());
        gc.setPrice(treefiddy);
        assertEquals(treefiddy, gc.getPrice());
    }

    @Test
    public void testDescription() {
        assertNull(gc.getDescription());
        gc.setDescription(sdDescription);
        assertEquals(sdDescription, gc.getDescription());
    }

    @Test
    public void testQuantity() {
        assertEquals(0, gc.getQuantity());
        gc.setQuantity(10);
        assertEquals(10, gc.getQuantity());
    }

    @Test
    public void testBalance() {
        assertNull(gc.getBalance());
        gc.setBalance(ten);
        assertEquals(ten, gc.getBalance());
    }

    @Test
    public void testEquals() {
        gc.setName("Store Credit");
        gc.setProductId("2057");
        gc.setPrice(treefiddy);
        gc.setDescription(sdDescription);
        gc.setQuantity(12);
        gc.setBalance(treefiddy);

        GiftCard gc2 = new GiftCard("Gift Certificate", "2353", ten, "Give the gift of music!", 56);
        GiftCard gc3 = new GiftCard("Store Credit", "2057", treefiddy, sdDescription, 12);

        assertNotEquals(gc, gc2);
        assertEquals(gc, gc3);
    }

    @Test
    void testToString() {
        GiftCard gc2 = new GiftCard("Gift Certificate", "2353", ten, "Give the gift of music!", 56);
        assertEquals(String.format("Name=Gift Certificate, ProductID=2353, Price=$10.00, Description=Give the gift of" +
                        " music!, QuantityOnHand=56, Balance=%s", gc2.getPrice()),
                gc2.toString());
    }
}