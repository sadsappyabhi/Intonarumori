package org.example;

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
    }

    public int updateProduct(String[] tokens) {

    }

    public int deleteProduct(String productId) {

    }
}
