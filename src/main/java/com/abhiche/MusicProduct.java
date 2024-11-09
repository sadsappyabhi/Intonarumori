package com.abhiche;

import java.util.GregorianCalendar;

/**
 * Abstract class of the Product interface for Recorded Music Products
 */

public abstract class MusicProduct implements Product {
    protected String id;
    protected Dollar price;
    protected String description;
    protected int quantity;

    protected String artist;
    protected String title;
    protected GregorianCalendar releaseDate;

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
     * @param releaseDate Product Release Date
     */

    public MusicProduct(String artist, String title, String id, Dollar price, String description, int quantity,
                        GregorianCalendar releaseDate) {
        this.setArtist(artist);
        this.setTitle(title);
        this.setProductId(id);
        this.setPrice(price);
        this.setDescription(description);
        this.setQuantity(quantity);
        this.setReleaseDate(releaseDate);
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
        DataValidation.nonEmptyString(id);
        this.id = id;
    }

    /**
     * A pair of getters and setters for Product Price
     */

    public Dollar getPrice() {
        return this.price;
    }

    public void setPrice(Dollar price) {
        DataValidation.positiveMoney(price);
        this.price = price;
    }
    /**
     * A pair of getters and setters for Product Description
     */

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        DataValidation.nonEmptyString(description);
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
     * A pair of getters and setters for Release Date
     */

    public GregorianCalendar getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(GregorianCalendar date) {
        DataValidation.nonEmptyDate(date);
        this.releaseDate = date;
    }


    /**
     * An override of Object.equals() for the sake of comparing Product object equality.
     * @param obj The other Product to compare to
     */

    @Override
    public boolean equals(Object obj) {
        boolean isEqual = false;
        if (obj instanceof MusicProduct otherProduct) {
            if (artist.equals(otherProduct.getArtist()) && title.equals(otherProduct.getTitle()) &&
                    price.equals(otherProduct.getPrice()) && id.equals(otherProduct.getProductId()) && quantity == otherProduct.getQuantity()
                    && description.equals(otherProduct.getDescription()) && releaseDate.equals(otherProduct.getReleaseDate())) {
                isEqual = true;
            }
        }
        return isEqual;
    }

    @Override
    public String toString() {
        String printDate = String.format("%04d-%02d-%02d",
                releaseDate.get(GregorianCalendar.YEAR),
                releaseDate.get(GregorianCalendar.MONTH) + 1,
                releaseDate.get(GregorianCalendar.DATE));
        return String.format("Artist=%s, Title=%s, ProductID=%s, Price=%s, Description=%s, " +
                        "QuantityOnHand=%d, ReleaseDate=%s", this.artist, this.title, this.id,
                this.price.toString(), this.description, this.quantity, printDate);
    }
}