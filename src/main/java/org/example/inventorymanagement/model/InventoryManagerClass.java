package org.example.inventorymanagement.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InventoryManagerClass {
    private List<Product> products;  // List to store products
    private List<Category> categories;  // List to store categories

    // Constructor: Initialize with sample data
    public InventoryManagerClass() {
        products = new ArrayList<>(); // List to store products
        categories = new ArrayList<>();   // List to store categories


        // Initialize sample categories
        Category stationery = new Category(1L, "Stationery");
        Category electronics = new Category(2L, "Electronics");

        categories.add(stationery);
        categories.add(electronics);

        // Initialize sample products
        products.add(new PaperProduct(1L, "Notebook", 2.50, "Stationery", 100, 200, "A4"));
        products.add(new WritingInstrument(2L, "Ballpoint Pen", 1.00, "Stationery", 50, "Blue", 0.7));
        products.add(new WritingInstrument(3L, "Fountain Pen", 15.00, "Stationery", 20, "Gold", 1.2));
        products.add(new WritingInstrument(4L, "Tablet", 500.00, "Electronics", 10, "None", 0.0));
    }

    // Method to add a product
    public void addProduct(Product product) {
        products.add(product);
    }

    // Method to retrieve all products
    public List<Product> getAllProducts() {
        return products;
    }

    // Method to filter products by category
    public List<Product> filterProductsByCategory(String categoryName) {
        return products.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase(categoryName))
                .collect(Collectors.toList()); // Collect filtered products into a list
    }

    // Method to retrieve all categories
    public List<Category> getAllCategories() {
        return categories;
    }

    // Method to display all products
    public void displayAllProducts() {
        System.out.println("All Products:");
        for (Product product : products) {
            System.out.println("ID: " + product.getId() + ", Name: " + product.getName() +
                    ", Price: $" + product.getPrice() + ", Quantity: " + product.getQuantity() +
                    ", Category: " + product.getCategory() + ", Value: $" + product.calculateValue());
        }
    }
}
