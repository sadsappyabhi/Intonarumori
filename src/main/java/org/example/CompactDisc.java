package org.example;
import java.util.GregorianCalendar;
/**
 * This class represents a Compact Disc in inventory
 */
public class CompactDisc extends MusicProduct {
        private DiscType type;
        public enum DiscType {
                CD120MM,
                CD80MM,
                CDR120MM,
                CDR80MM;
        }

        /**
         * Default (empty) constructor for a CompactDisc Object
         */
        public CompactDisc() {
                // Do nothing
        }

        /**
         * Explicit constructor for a CompactDisc Object.
         */
        public CompactDisc(String artist, String title, String id, Dollar price, String description, int quantity,
                           int duration, GregorianCalendar releaseDate, DiscType type) {
                super(artist, title, id, price, description, quantity, releaseDate);
                this.setDiscType(type);
        }

        /**
         * A pair of getters and setters for DiscType.
         */
        public DiscType getDiscType() {
                return this.type;
        }

        public void setDiscType(DiscType type) {
                this.type = type;
        }

        /**
         * Overrides Object.equals() for accurate object equality comparison.
         */
        @Override
        public boolean equals(Object obj) {
                boolean isEqual = false;
                if (obj instanceof CompactDisc otherDisc) {
                        if (super.equals(obj) && this.getDiscType().equals(otherDisc.getDiscType())) {
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
                return String.format("%s, DiscType=%s", super.toString(), this.getDiscType());
        }
}