package org.example;

/**
 * Abstract class of the Product interface
 */

public abstract class MusicProduct implements Product {
    protected String id;
    protected Dollar price;
    protected String description;
    protected int quantity;

    protected String artist;
    protected String title;

    /**
     * Default constructor, creates an empty object.
     */

    public MusicProduct() {

    }

    /**
     * Constructor to define basic product attributes on creation.
     *
     * @param artist      Product Artist
     * @param title       Product Title
     * @param id          Product ID
     * @param price       Product Price
     * @param description Product Description
     * @param quantity    Product Quantity-on-hand
     */

    public MusicProduct(String artist, String title, String id, Dollar price, String description, int quantity) {
        this.setArtist(artist);
        this.setTitle(title);
        this.setProductId(id);
        this.setPrice(price);
        this.setDescription(description);
        this.setQuantity(quantity);
    }


    /**
     * A pair of getters and setters for Product Artist
     */

    public String getArtist() {
        return this.artist;
    }

    public void setArtist(String artist) {
        DataValidation.nonEmptyString(artist);
        this.artist = artist;
    }

    /**
     * A pair of getters and setters for Product Title
     */

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        DataValidation.nonEmptyString(title);
        this.title = title;
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
        if (obj instanceof MusicProduct otherProduct) {
            if (artist.equals(otherProduct.artist) && title.equals(otherProduct.title) &&
                    price.equals(otherProduct.price) && id.equals(otherProduct.id) && quantity == otherProduct.quantity
                    && description.equals(otherProduct.getDescription())) {
                isEqual = true;
            }
        }
        return isEqual;
    }
}