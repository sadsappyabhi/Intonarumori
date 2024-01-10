package org.example;

public interface Lookup {
    /**
     * A lookup will do one thing - return true if the product matches the lookup criteria.
     * @param product The product to test for a match.
     * @return boolean Whether or not the Lookup finds a match.
     */

    boolean matches (Product product);
}