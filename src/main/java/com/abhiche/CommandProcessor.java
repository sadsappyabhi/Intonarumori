package com.abhiche;

import java.util.GregorianCalendar;
import java.util.Scanner;
import java.io.*;

public class CommandProcessor {
    private Inventory inventory;

/**
     * Constructor for a CommandProcessor object.
     * @param i The inventory to run commands on
     */

    public CommandProcessor(Inventory i) {
        this.inventory = i;
    }

/**
     * Reads text commands from file and executes them on Inventory
     * @param fileName File to read text commands from
     * @return int Number of successfully executed commands
     */

    public int process(String fileName) throws IOException {
        Scanner in = null;
        int commandsExecuted = 0;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            in = new Scanner(fis);
            while (in.hasNextLine()) {
                commandsExecuted += this.processLine(in.nextLine());
            }
        } catch (IOException e) {
            System.out.println("File not Found!");
            return 0;
        } finally {
            if (in != null) {
                in.close();
            }
        }
        return commandsExecuted;
    }

    /**
     * Encapsulates the logic for processing an individual line, used by this.process()
     * @param line
     * @return Number of successfully executed commands
     */

    public int processLine(String line) {
        int commandsExecuted = 0;
        String[] tokens = line.split(" ");
        if (tokens[0].equalsIgnoreCase("ADD")) {
            commandsExecuted += this.addProduct(tokens);
        }
        if (tokens[0].equalsIgnoreCase("UPDATE")) {
            commandsExecuted += this.updateProduct(tokens);
        }
        if (tokens[0].equalsIgnoreCase("DELETE")) {
            commandsExecuted += this.deleteProduct(tokens[1]);
        }
        return commandsExecuted;
    }

    /**
     * Encapsulates the ADD branch of this.processLine() for the sake of readability and organization
     * @param tokens A string array of tokens derived from this.processLine() for the sake of parsing a line of text
     *               into commands
     * @return Number of successfully executed commands
     */


    public int addProduct(String[] tokens) {
        // TODO:
        if (tokens.length == 2) {
            String productType = tokens[1].toLowerCase();
            switch (productType) {
                case "cassette":
                    this.inventory.add(new Cassette());
                    return 1;
                case "compactdisc":
                    this.inventory.add(new CompactDisc());
                    return 1;
                case "giftcard":
                    this.inventory.add(new GiftCard());
                    return 1;
                case "vinyl":
                    this.inventory.add(new Vinyl());
                    return 1;
                case "zine":
                    this.inventory.add(new Zine());
                    return 1;
//                case "clothing":
//                    this.inventory.add(new Clothing());
//                    return 1;
//                case "miscmerch":
//                    this.inventory.add(new MiscMerch());
//                    return 1;
            }
        }
        String[] fields = tokens[2].split(",");
        String[][] kv = new String[fields.length][];
        int i = 0;
        for (String field : fields) {
            kv[i++] = field.split("=");
        }

        // initialize fields for key/value pairs.
        String id = null;
        Dollar price = null;
        String desc = null;
        String quantity = null;
        String artist = null;
        String title = null;
        GregorianCalendar releaseDate = null;
        int duration;
        CompactDisc.DiscType type = null;
        Vinyl.RotationSpeed rpm = null;
        Vinyl.DiscSize size = null;
        String name = null;
        Dollar balance = null;
        String issue = null;

        // Loops through all kv pairs and assigns the value to a variable
        for (String[] pair : kv) {
            String field = pair[0].toLowerCase();
            switch (field) {
                case "id":
                     id = (pair[1] != null) ? pair[1] : id;
                     break;
                case "price":
                    price = (pair[1] != null) ? new Dollar(Double.parseDouble(pair[1])) : price;
                    break;
                case "desc":
                    desc = (pair[1] != null) ? pair[1] : desc;
                    break;
                case "quantity":
                    quantity = (pair[1] != null) ? pair[1] : quantity;
                    break;
                case "artist":
                    artist = (pair[1] != null) ? pair[1] : artist;
                    break;
                case "title":
                    title = (pair[1] != null) ? pair[1] : title;
                    break;
                case "releasedate":
                    if (pair[1] != null) {
                        String year = pair[1].substring(0, 4);
                        String month = pair[1].substring(4, 6);
                        String day = pair[1].substring(6, 8);
                        releaseDate = new GregorianCalendar(Integer.parseInt(year),
                                (Integer.parseInt(month) - 1),
                                Integer.parseInt(day));
                    }
                case "duration":
                    duration = (pair[1] != null) ? Integer.parseInt(pair[1]) : duration;
                    break;
                case "disctype":
                    String typeString = pair[1];
                    switch (typeString) {
                        case "cd120mm":
                            type = CompactDisc.DiscType.CD120MM;
                            break;
                        case "cd80mm":
                            type = CompactDisc.DiscType.CD80MM;
                            break;
                        case "cdr120mm":
                            type = CompactDisc.DiscType.CDR120MM;
                            break;
                        case "cdr80mm":
                            type = CompactDisc.DiscType.CDR80MM;
                            break;
                    }
                case "rpm":
                    String rpmString = pair[1];
                    switch (rpmString) {
                        case "33":
                            rpm = Vinyl.RotationSpeed.RPM33;
                            break;
                        case "45":
                            rpm = Vinyl.RotationSpeed.RPM45;
                            break;
                    }
                case "discsize":
                    String sizeString = pair[1];
                    switch (sizeString) {
                        case "twelve":
                            size = Vinyl.DiscSize.TWELVE;
                            break;
                        case "seven":
                            size = Vinyl.DiscSize.SEVEN;
                            break;
                    }
                case "name":
                    name = (pair[1] != null) ? pair[1] : name;
                    break;
                case "balance":
                    balance = (pair[1] != null) ? new Dollar(Double.parseDouble(pair[1])) : balance;
                case "issue":
                    issue = (pair[1] != null) ? pair[1] : issue;
            }
            // Create a product and assign values to its attributes
            Product p = null;
            
        }



        return -1;
    }

    public int updateProduct(String[] tokens) {
        return -1;
    }

    public int deleteProduct(String productId) {
        return -1;
    }

    public int process(InputStream stream) {
        Scanner in = null;
        int commandsExecuted = 0;
        in = new Scanner(stream);
        while (in.hasNextLine()) {
            commandsExecuted += this.processLine(in.nextLine());
        }
        return commandsExecuted;
    }
}
