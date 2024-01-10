package org.example;

import org.example.AbstractProduct;
import org.example.Dollar;
import org.example.DataValidation;

import java.util.GregorianCalendar;

/**
 * This class represents a Cassette Tape in inventory
 */

public class Cassette extends MusicProduct {

    private int duration;
    private GregorianCalendar releaseDate;

    /**
     * Explicit constructor for a Cassette object.
     */
    public Cassette(String artist, String title, String id, Dollar price, String description, int quantity,
                    int duration,
                    GregorianCalendar releaseDate) {
        super(artist, title, id, price, description, quantity);
        this.setDuration(duration);
        this.setReleaseDate(releaseDate);
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
     * Overrides Object.equals() for accurate object equality comparison
     */

    @Override
    public boolean equals(Object obj) {
        boolean isEqual = false;
        if (obj instanceof Cassette otherCass) {
            if (super.equals(obj) && releaseDate.equals(otherCass.releaseDate)) {
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
        String printDate = String.format("%04d-%02d-%02d",
                releaseDate.get(GregorianCalendar.YEAR),
                releaseDate.get(GregorianCalendar.MONTH) + 1,
                releaseDate.get(GregorianCalendar.DATE));
        return String.format("Cassette[Name");
    }




}