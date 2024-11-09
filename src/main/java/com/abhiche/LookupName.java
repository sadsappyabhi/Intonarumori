package com.abhiche;

public class LookupName implements Lookup {

    private String query;
    /**
     * Constructs a LookupName object
     * @param name The product name to search for.
     */

    public LookupName(String name) {
        this.query = name;
    }

    /**
     * Returns true or false based on whether the product passed to this method matches the LookupName (query)
     * passed to the LookupName constructor.
     * @param product The product to search for
     * @return boolean If the product is found.
     */

    public boolean matches(Product product) {
        if (product instanceof MusicProduct album) {
            if (album.getTitle() == null && query == null) {
                return true;
            }
            else if (album.getTitle() == null || query == null) {
                return false;
            }
            else return album.getTitle().startsWith(query);
        }
        else if (product instanceof MerchProduct merch) {
            if (merch.getName() == null && query == null) {
                return true;
            }
            else if (merch.getName() == null || query == null) {
                return false;
            }
            else return merch.getName().startsWith(query);
        }
        return false;
    }
}