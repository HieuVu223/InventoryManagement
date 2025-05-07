package org.example.inventorymanagement.model;

public class Main {
    public static void main(String[] args) {
        // Create an instance of InventoryManagerClass
        InventoryManagerClass inventoryManager = new InventoryManagerClass();

        // Demonstrating polymorphism
        System.out.println("Demonstrating Polymorphism with calculateValue():");
        for (Product product : inventoryManager.getAllProducts()) {
            System.out.println("Product Name: " + product.getName() +
                    ", Quantity: " + product.getQuantity() +
                    ", Value: $" + product.calculateValue());
        }

        System.out.println();

        //Step 3: filtering products by category (collection handling)
        System.out.println("Filtered Products by Category (Stationery):");
        inventoryManager.filterProductsByCategory("Stationery").forEach(product -> {
            System.out.println("Product Name: " + product.getName() +
                    ", Category: " + product.getCategory());
        });

        System.out.println();

        System.out.println("Filtered Products by Category (Electronics):");
        inventoryManager.filterProductsByCategory("Electronics").forEach(product -> {
            System.out.println("Product Name: " + product.getName() +
                    ", Category: " + product.getCategory());
        });
    }
}

