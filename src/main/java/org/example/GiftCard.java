package org.example;

/**
 * This class represents a GiftCard object in inventory
 */
public class GiftCard extends MerchProduct {
    private Dollar balance;

    /**
     * Default (empty) constructor for a GiftCard Object
     */
    public GiftCard() {
        // Do nothing
    }

    /**
     * Explicit constructor for a GiftCard Object
     * balance is equal to price when creating a new GiftCard.
     */
    public GiftCard(String name, String id, Dollar price, String description, int quantity) {
        super(name, id, price, description, quantity);
//        DataValidation.positiveMoney(price);
        this.balance = price;
    }

    /**
     * A pair of getters and setters for the current balance of the GiftCard
     */
    public Dollar getBalance() {
        return this.balance;
    }

    public void setBalance(Dollar newBalance) {
        // TODO: Design a plan for how this will work with a process transaction method.
        DataValidation.positiveMoney(newBalance);
        this.balance = newBalance;
    }

    /**
     * Processes a transaction
     */

    // TODO:

    /**
     * Overrides Object.equals() for accurate equality comparison
     */
    public boolean equals(Object obj) {
        boolean isEqual = false;
        if (obj instanceof GiftCard otherCard) {
            if (super.equals(obj) && this.getBalance().equals(otherCard.getBalance())) {
                isEqual = true;
            }
        }
        return isEqual;
    }

    /**
     * Overrides Object.toString() for debugging purposes
     */
    public String toString() {
        return String.format("%s, Balance=%s", super.toString(), this.getBalance().toString());
    }
}