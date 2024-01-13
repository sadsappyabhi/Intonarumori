package org.example;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

/**
 * This class represents the organization's Inventory
 */
public class Inventory implements Serializable {
    private int nextIdNumber;
    private List<Product> products;
    private List<PurchaseOrder> savedOrders;

    /**
     * Default (empty) constructor for an Inventory object
     */
    public Inventory() {
        this.nextIdNumber = 1;
        this.products = new ArrayList<>();
        this.savedOrders = new ArrayList<>();
    }

    /**
     * Return the number of products currently in Inventory
     */
    public int getProductCount() {
        return products.size();
    }

    /**
     * Utility method for null-safe equality comparison
     */
    private static boolean nullSafeEquals(Object obj1, Object obj2) {
        return Objects.equals(obj1, obj2);
    }

    /**
     * Adds a product to inventory. Parameter cannot be a product that already exists in inventory. ProductID will be
     * issued automatically upon successfully adding a product.
     *
     * @param prod The product to add
     * @return boolean Returns true when a product is successfully added and false if the product cannot be added for
     * any reason.
     */
    public boolean add(Product prod) {
        if (prod == null) {
            return false;
        }

        if (products.isEmpty()) {
            prod.setProductId(Integer.toString(this.nextIdNumber++));
            products.add(prod);
            return true;
        }

        boolean prodExists = false;
        for (Product product : products) {
            if (nullSafeEquals(product, prod)) {
                prodExists = true;
            }
        }

        if (!prodExists) {
            prod.setProductId(Integer.toString(this.nextIdNumber++));
            products.add(prod);
            for (PurchaseOrder order : savedOrders) {
                if (orderProcessable(order)) {
                    processOrder(order);
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Removes a product from Inventory.
     *
     * @param prod The product to remove
     * @return boolean True if the product was successfully removed.
     */
    public boolean remove(Product prod) {
        Iterator<Product> productsItr = this.products.iterator();
        while (productsItr.hasNext()) {
            Product myProd = productsItr.next();
            if (myProd.getProductId().equals(prod.getProductId())) {
                productsItr.remove();
                return true;
            }
        }
        return false;
    }

    /**
     * Creates and returns an array of products in Inventory that match a given Lookup criteria
     *
     * @param query A query indicating what to search for
     * @return Product[] An array of matching products
     */
    public Product[] findProducts(Lookup query) {
        ArrayList<Product> result = new ArrayList<Product>();
        for (Product product : products) {
            if (query.matches(product)) {
                result.add(product);
            }
        }
        return result.toArray(new Product[result.size()]);
    }

    /**
     * Returns the entire Inventory as an array
     *
     * @Return Product[] An array of all products in Inventory
     */
    public Product[] allProducts() {
        return products.toArray(new Product[products.size()]);
    }

    /**
     * Builds an Inventory object from a persistent object file.
     *
     * @param fileName The filename of the saved Inventory
     * @return an Inventory object read from file
     */
    public static Inventory readFromFile(String fileName) throws IOException, ClassNotFoundException {
        Inventory result = null;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            result = (Inventory) ois.readObject();
            ois.close();
            fis.close();
        } catch(FileNotFoundException e) {
            throw new RuntimeException("File not found: " + fileName, e);
        }
        return result;
    }

    /**
     * Writes the current Inventory to file via object serialization
     *
     * @param fileName The name of the file to write to
     */
    public void writeToFile(String fileName) throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException("No write permissions!", e);
        }
    }

    /**
     * Processes a purchase order. Products are only removed from inventory if ALL products are available for
     * fulfillment. If all products are not available, the order is saved as a back order. Back orders are
     * automatically processed once all products become available.
     *
     * @param order The Purchase Order to process
     * @return boolean True if the order can be processed, false if not.
     */
    public boolean processOrder(PurchaseOrder order) {
        if (orderProcessable(order)) {
            Iterator<Product> iterator = products.iterator();
            while (iterator.hasNext()) {
                Product prod = iterator.next();
                for (Product product : order.getProducts()) {
                    if (nullSafeEquals(prod.getProductId(), product.getProductId())) {
                        prod.setQuantity(prod.getQuantity() - product.getQuantity());
                        if (prod.getQuantity() == 0) {
                            iterator.remove();
                        }
                        break;
                    }
                }
            }
            return true;
        } else {
            savedOrders.add(order);
            return false;
        }
    }

    public boolean quantityExistsInInventory(Product product) {
        for (Product prod : products) {
            if (nullSafeEquals(prod.getProductId(), product.getProductId())) {
                return prod.getQuantity() - product.getQuantity() >= 0;
            }
        }
        return false;
    }

    public boolean orderProcessable(PurchaseOrder order) {
        boolean processable = true;
        for (Product product : order.getProducts()) {
            if (!quantityExistsInInventory(product)) {
                processable = false;
            }
        }
        return processable;
    }
}
