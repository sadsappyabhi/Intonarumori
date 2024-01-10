import org.example.AbstractProduct;
import org.example.Dollar;

import java.util.GregorianCalendar;

/**
 * This class represents a Cassette Tape in inventory
 */

public class Cassette extends AbstractProduct {

    private int duration;
    private GregorianCalendar releaseDate;

    /**
     * Explicit constructor for a Cassette object.
     */
    public Cassette(String name, String id, Dollar price, String description, int quantity, int duration,
                    GregorianCalendar releaseDate) {
        super(name, id, price, description, quantity);
        this.duration = duration;
        this.setDate(releaseDate);
    }

    /**
     * A pair of getters and setters for Cassette Duration
     */

    public String getDuration() {
        return String.format("C-%d", this.duration);
    }

    public void setDuration(int duration) {
        Validation.
    }


}