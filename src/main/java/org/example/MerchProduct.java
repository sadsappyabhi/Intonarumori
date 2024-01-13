package org.example;

/**
 * Abstract class of the Product interface for General Merch Products
 */

public abstract class MerchProduct implements Product {
    protected String name;
    protected String id;
    protected Dollar price;
    protected String description;
    protected int quantity;

    /**
     * Default constructor, creates an empty object.
     */

    public MerchProduct() {

    }

    /**
     * Constructor to define basic product attributes on creation.
     *
     * @param name        Product Name
     * @param id          Product ID
     * @param price       Product Price
     * @param description Product Description
     * @param quantity    Product Quantity-on-hand
     */

    public MerchProduct(String name, String id, Dollar price, String description, int quantity) {
        this.setName(name);
        this.setProductId(id);
        this.setPrice(price);
        this.setDescription(description);
        this.setQuantity(quantity);
    }

    /**
     * A pair of getters/setters for Product Name
     */
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * A pair of getters and setters for Product ID
     */

    public String getProductId() {
        return this.id;
    }

    public void setProductId(String id) {
        this.id = id;
    }

    /**
     * A pair of getters and setters for Product Price
     */

    public Dollar getPrice() {
        return this.price;
    }

    public void setPrice(Dollar price) {
        this.price = price;
    }
    /**
     * A pair of getters and setters for Product Description
     */

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * A pair of getters and setters for Product Quantity-On-Hand
     */

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * An override of Object.equals() for the sake of comparing Product object equality.
     * @param obj The other Product to compare to
     */

    @Override
    public boolean equals(Object obj) {
        boolean isEqual = false;
        if (obj instanceof MerchProduct otherProduct) {
            if (name.equals(otherProduct.name) && price.equals(otherProduct.price) && id.equals(otherProduct.id)
                    && quantity == otherProduct.quantity && description.equals(otherProduct.getDescription())) {
                isEqual = true;
            }
        }
        return isEqual;
    }

    @Override
    public String toString() {
        return String.format("Name=%s, ProductID=%s, Price=%s, Description=%s, QuantityOnHand=%d"
                , this.getName(), this.getProductId(), this.getPrice(), this.getDescription(), this.getQuantity());
    }
}