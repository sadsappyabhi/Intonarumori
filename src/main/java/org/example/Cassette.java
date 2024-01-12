package org.example;
import java.util.GregorianCalendar;

/**
 * This class represents a Cassette Tape in inventory
 */

public class Cassette extends MusicProduct {

    private int duration;
    private GregorianCalendar releaseDate;

    /**
     * Default (empty) constructor for a Cassette object.
     */

    public Cassette() {
        // Do nothing
    }

    /**
     * Explicit constructor for a Cassette object.
     */
    public Cassette(String artist, String title, String id, Dollar price, String description, int quantity,
                    int duration,
                    GregorianCalendar releaseDate) {
        super(artist, title, id, price, description, quantity, releaseDate);
        this.setDuration(duration);
    }

    /**
     * A pair of getters and setters for Cassette Duration
     */

    public String getDuration() {
        return String.format("C-%d", this.duration);
    }

    public void setDuration(int duration) {
        DataValidation.greater(duration, 0);
        this.duration = duration;
    }

    /**
     * Overrides Object.equals() for accurate object equality comparison
     */

    @Override
    public boolean equals(Object obj) {
        boolean isEqual = false;
        if (obj instanceof Cassette otherCass) {
            if (super.equals(obj) && this.getDuration().equals(otherCass.getDuration())) {
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
        return String.format("%s, Duration=%s", super.toString(), this.getDuration());
    }

}