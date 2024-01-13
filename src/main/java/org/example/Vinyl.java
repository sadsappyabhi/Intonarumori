package org.example;
import java.util.GregorianCalendar;
/**
 * This class represents a Vinyl record in inventory
 */
public class Vinyl extends MusicProduct {
    private RotationSpeed speed;
    private DiscSize size;

    public enum RotationSpeed {
        RPM33,
        RPM45;

        private RotationSpeed speed;
        @Override
        public String toString() {
            String rotation = "";
            if (this.speed.equals(RPM33)) {
                rotation = "33 1/3 RPM";
            }
            else if (this.speed.equals(RPM45)) {
                rotation = "45 RPM";
            }
            return rotation;
        }
    }

    public enum DiscSize {
        TWELVE,
        SEVEN;

        private DiscSize size;

        @Override
        public String toString() {
            String size = "";
            if (this.size.equals(TWELVE)) {
                size = "12\"";
            }
            else if (this.size.equals(SEVEN)) {
                size = "7\"";
            }
            return size;
        }
    }

    /**
     * Default (empty) constructor for a Vinyl Object
     */
    public Vinyl() {
        // Do nothing
    }

    /**
     * Explicit constructor for a Vinyl Object
     */
    public Vinyl(String artist, String title, String id, Dollar price, String description, int quantity,
                 GregorianCalendar releaseDate, RotationSpeed speed, DiscSize size) {
        super(artist, title, id, price, description, quantity, releaseDate);
        this.setRotationSpeed(speed);
        this.setDiscSize(size);
    }

    /**
     * A pair of getters and setters for Rotation Speed
     */
    public RotationSpeed getRotationSpeed() {
        return this.speed;
    }

    public void setRotationSpeed(RotationSpeed speed) {
        this.speed = speed;
    }

    /**
     * A pair of getters and setters for Disc Size
     */
    public DiscSize getDiscSize() {
        return this.size;
    }

    public void setDiscSize(DiscSize size) {
        this.size = size;
    }

    /**
     * Overrides Object.equals() for accurate object equality comparison.
     */

    @Override
    public boolean equals(Object obj) {
        boolean isEqual = false;
        if (obj instanceof Vinyl otherRecord) {
            if (super.equals(obj) && this.getRotationSpeed().equals(otherRecord.getRotationSpeed()) &&
                    this.getDiscSize().equals(otherRecord.getDiscSize())) {
                isEqual = true;
            }
        }
        return isEqual;
    }

    /**
     * Overrides Object.toString() for debugging purposes.
     */
    @Override
    public String toString() {
        return String.format("%s, RotationSpeed=%s, DiscSize=%s", super.toString(), this.getRotationSpeed(),
                this.getDiscSize());
    }
}