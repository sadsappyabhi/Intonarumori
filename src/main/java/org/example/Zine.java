package org.example;

/**
 * This class represents a Zine object in inventory
 */
public class Zine extends MerchProduct {
    private String issueIdentifier;

    /**
     * Default (empty) constructor for a Zine Object
     */
    public Zine() {
        // Do nothing
    }

    /**
     * Explicit constructor for a Zine Object
     */
    public Zine(String name, String id, Dollar price, String description, int quantity, String issueIdentifier) {
        super(name, id, price, description, quantity);
        this.setIssueIdentifier(issueIdentifier);
    }

    /**
     * A pair of getters and setters for IssueIdentifier. This can be issue number, volume number, collection, etc.
     * anything that can be used to identify the specific issue of the zine.
     */
    public String getIssueIdentifier() {
        return this.issueIdentifier;
    }

    public void setIssueIdentifier(String identifier) {
        this.issueIdentifier = identifier;
    }

    /**
     * Overrides Object.equals() for accurate object equality comparison
     */
    public boolean equals(Object obj) {
        boolean isEqual = false;
        if (obj instanceof Zine otherZine) {
            if (super.equals(obj) && this.getIssueIdentifier().equals(otherZine.getIssueIdentifier())) {
                isEqual = true;
            }
        }
        return isEqual;
    }

    /**
     * Overrides Object.toString() for debugging purposes
     */
    public String toString() {
        return String.format("%s, IssueIdentifier=%s", super.toString(), this.getIssueIdentifier());
    }

}