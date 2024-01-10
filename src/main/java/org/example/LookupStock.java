package org.example;

public class LookupStock implements Lookup {

    private int amount;
    /**
     * Constructs a LookupStock object
     * @param amount The QOH you wish to test for.
     */

    public LookupStock(int amount) {
        this.amount = amount;
    }

    /**
     * Returns true if the product's QOH is less than or equal to the LookupStock Amount and false otherwise.
     * @param product The product to search for
     * @return boolean If the product has low stock
     */

    public boolean matches(Product product) {
        return product.getQuantity() <= amount;
    }
}