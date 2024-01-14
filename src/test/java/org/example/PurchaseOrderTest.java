package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseOrderTest {
    PurchaseOrder po;
    PurchaseOrder test;
    PurchaseOrder test2;

    @BeforeEach
    public void setUp() {
        this.po = new PurchaseOrder("123", "John Doe", "555-1234");
        this.test = new PurchaseOrder("456", "Paul Smith", "867-5309");
        this.test2 = new PurchaseOrder("789", "Ada Lovelace", "667-9684");
    }

    @Test
    public void testConstructor() {
        assertNotNull(po);
        assertNotNull(test);
        assertNotNull(test2);
    }

    @Test
    public void testConstructor2() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            PurchaseOrder empty = new PurchaseOrder("", "", "");
        });
    }
    @Test
    public void getOrderId() {
        assertEquals("123", po.getOrderId());
        assertEquals("456", test.getOrderId());
        assertEquals("789", test2.getOrderId());
    }

    @Test
    public void getCustName() {
        assertEquals("John Doe", po.getCustName());
        assertEquals("Paul Smith", test.getCustName());
        assertEquals("Ada Lovelace", test2.getCustName());
    }

    @Test
    public void getPhoneNumber() {
        assertEquals("555-1234", po.getPhoneNumber());
        assertEquals("867-5309", test.getPhoneNumber());
        assertEquals("667-9684", test2.getPhoneNumber());
    }

    @Test
    public void add() {
        Cassette hg = new Cassette();
        ArrayList<Product> testList = new ArrayList<Product>();
        testList.add(hg);
        po.add(hg);
        assertEquals(testList, po.getProducts());
    }

    @Test
    public void getProducts() {
        Cassette hg = new Cassette();
        CompactDisc lib = new CompactDisc();
        Vinyl gr = new Vinyl();
        ArrayList<Product> testList = new ArrayList<Product>();
        testList.add(hg);
        testList.add(lib);
        testList.add(gr);
        po.add(hg);
        po.add(lib);
        po.add(gr);
        assertEquals(testList, po.getProducts());
    }
}