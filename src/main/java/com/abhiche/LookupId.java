package com.abhiche;

public class LookupId implements Lookup {
    private String lookupId;

    /**
     * Constructs a LookupId object
     * @param searchId The product ID to search for.
     */

    public LookupId(String searchId) {
        this.lookupId = searchId;
    }

    /**
     * Returns true or false whether the product passed to this method matches the lookupId passed to the
     * LookupId constructor.
     * @param product The product to search for
     * @return boolean If the product is found.
     */

    public boolean matches(Product product) {
        if (product.getProductId() == null && lookupId == null) {
            return true;
        } else if (product.getProductId() == null || lookupId == null) {
            return false;
        }
        else return product.getProductId().equals(lookupId);
    }
}