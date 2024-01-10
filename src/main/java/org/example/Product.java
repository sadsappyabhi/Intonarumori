package org.example;

/**
 * This interface sets the basic criteria required of any product to work within the Intonarumori inventory tracking
 * system. Implementing this interface allows for seamless integration of your product into the inventory system.
 */

public interface Product {


    /**
     * Return the product name.
     * @return String Product name
     */

    String getName();

    /**
     * Set product name.
     * @param name Product name
     */

    void setName(String name);

    /**
     * Return product ID
     * @return String Id
     */

    String getProductId();

    /**
     * Set product ID
     * @param id Product ID
     */

    void setId(String id);
    /**
     * Return the product description.
     * @return String Product description
     */
    /**
     * Return the product price.
     * @return Dollar Product Price
     */

    Dollar getPrice();

    /**
     * Set the product price.
     * @param price Product price
     */

    void setPrice(Dollar price);

    String getDescription();

    /**
     * Set the product description.
     * @param desc Product description
     */

    void setDescription(String desc);

    /**
     * Return product quantity in stock
     * @return int Product quantity
     */

    int getQuantity();

    /**
     * Set product quantity
     * @param quantity Product quantity
     */

    void setQuantity(int quantity);
}