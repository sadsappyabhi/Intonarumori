package com.abhiche;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PurchaseOrder implements Serializable {
    private String orderId;
    private String custName;
    private String phoneNumber;
    private List<Product> products;

    /**
     * Constructor for a PurchaseOrder object. custName and phone cannot be empty strings or null
     *
     * @param orderId Order ID
     * @param custName Name of Customer placing the order
     * @param phoneNumber Customer's phone number.
     */
    public PurchaseOrder(String orderId, String custName, String phoneNumber) {
        DataValidation.nonEmptyString(orderId);
        DataValidation.nonEmptyString(custName);
        DataValidation.nonEmptyString(phoneNumber);
        this.orderId = orderId;
        this.custName = custName;
        this.phoneNumber = phoneNumber;
        this.products = new ArrayList<Product>();
    }

    /**
     * Accessor method for Order ID
     * @return String Order ID
     */
    public String getOrderId() {
        return this.orderId;
    }

    /**
     * Accessor method for Customer Name
     * @return String Customer Name
     */
    public String getCustName() {
        return this.custName;
    }

    /**
     * Accessor method for Customer Phone Number
     * @return String Customer Phone Number
     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * Adds a product to the order
     * @param product Product to be added to Purchase Order
     */
    public void add(Product product) {
        products.add(product);
    }

    /**
     * Returns a list of all products in the Purchase Order
     * @return List<Product> List of all products in the Purchase Order
     */
    public List<Product> getProducts() {
        return products;
    }
}
