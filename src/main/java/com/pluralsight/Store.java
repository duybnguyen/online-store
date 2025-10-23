
package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Store {

    public static void main(String[] args) {

        // Create lists for inventory and the shopping cart
        ArrayList<Product> inventory = new ArrayList<>();
        ArrayList<Product> cart = new ArrayList<>();

        // Load inventory from the data file (pipe-delimited: id|name|price)
        loadInventory("products.csv", inventory);

        // Main menu loop
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 3) {
            System.out.println("\nWelcome to the Online Store!");
            System.out.println("1. Show Products");
            System.out.println("2. Show Cart");
            System.out.println("3. Exit");
            System.out.print("Your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter 1, 2, or 3.");
                scanner.nextLine();                 // discard bad input
                continue;
            }
            choice = scanner.nextInt();
            scanner.nextLine();                     // clear newline

            switch (choice) {
                case 1 -> displayProducts(inventory, cart, scanner);
                case 2 -> displayCart(cart, scanner);
                case 3 -> System.out.println("Thank you for shopping with us!");
                default -> System.out.println("Invalid choice!");
            }
        }
        scanner.close();
    }

    /**
     * Reads product data from a file and populates the inventory list.
     * File format (pipe-delimited):
     * id|name|price
     * <p>
     * Example line:
     * A17|Wireless Mouse|19.99
     */
    public static void loadInventory(String fileName, ArrayList<Product> inventory) {
        try {
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] productParts = line.split("\\|");

                if (productParts.length != 4) {
                    System.out.println("Skipping malformed product line: " + line);
                    continue;
                }
                double price = Double.parseDouble(productParts[2]);

                Product product = new Product(productParts[0], productParts[1], price, productParts[3]);

                inventory.add(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Displays all products and lets the user add one to the cart.
     * Typing X returns to the main menu.
     */
    public static void displayProducts(ArrayList<Product> inventory,
                                       ArrayList<Product> cart,
                                       Scanner scanner) {
        System.out.println("=========================================================");
        for (Product p: inventory) {
            System.out.println(p);
        }
        System.out.println("=========================================================");
        Product product = null;

        while (product == null) {
            System.out.print("\nEnter a SKU to add item to cart (X to return to main menu): ");
            String sku = scanner.nextLine();
            if (sku.equalsIgnoreCase("X")) return;
            product = findProductById(sku, inventory);
        }

        cart.add(product);
        System.out.println("\nProduct added to cart!");
    }

    /**
     * Shows the contents of the cart, calculates the total,
     * and offers the option to check out.
     */
    public static void displayCart(ArrayList<Product> cart, Scanner scanner) {
        if (cart.isEmpty()) {
            System.out.println("\nThere are currently no items in your cart!");
            return;
        }
        System.out.println("Showing items in cart: ");
        System.out.println("\n=========================================================");
        for (Product p: cart) {
            System.out.println(p);
        }
        promptForChoice("\nC to checkout, X to return to main menu: ", scanner);
        System.out.println("=========================================================");
        double total = 0;
        for (Product p: cart) {
            total += p.getPrice();
        }
        checkOut(cart, total, scanner);
    }

    /**
     * Handles the checkout process:
     * 1. Confirm that the user wants to buy.
     * 2. Accept payment and calculate change.
     * 3. Display a simple receipt.
     * 4. Clear the cart.
     */
    public static void checkOut(ArrayList<Product> cart,
                                double totalAmount,
                                Scanner scanner) {
        // TODO: implement steps listed above
        System.out.println("\nYour total is $" + totalAmount);
        promptForChoice("\nC to confirm your payment, X to return to main menu: ", scanner);

        System.out.println("\n=========================================================");
        System.out.println("Thank you for your purchase!\n");
        for (Product p: cart) {
            System.out.println(p);
        }
        System.out.println("\nTotal: $" + totalAmount);
        System.out.println("=========================================================");
        cart.clear();
    }

    /**
    Continuously prompts user for a choice
     */
    public static void promptForChoice(String message, Scanner scanner) {
        String choice = "";

        while (!choice.equalsIgnoreCase("C") && !choice.equalsIgnoreCase("X")) {
            System.out.print(message);
            choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("C") && !choice.equalsIgnoreCase("X")) {
                System.out.println("\nInvalid choice!");
            }
        }
    }

    /**
     * Searches a list for a product by its id.
     *
     * @return the matching Product, or null if not found
     */
    public static Product findProductById(String id, ArrayList<Product> inventory) {
        // TODO: loop over the list and compare ids
        for (Product p: inventory) {
            if (p.getSku().equalsIgnoreCase(id)) {
                return p;
            }
        }
        System.out.println("\nNo item found with SKU: " + id + "\n");
        return null;
    }
}

 