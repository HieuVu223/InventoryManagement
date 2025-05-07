package org.example.inventorymanagement.model;

public class WritingInstrument extends Product implements Categorizable {
    private String inkColor; // Color of the ink (e.g., blue, black)
    private double tipSize;  // Tip size in mm (e.g., 0.5, 1.0)

    // Constructor
    public WritingInstrument(Long id, String name, double price, String category, int quantity, String inkColor, double tipSize) {
        super(id, name, price, category, quantity);
        this.inkColor = inkColor;
        this.tipSize = tipSize;
    }

    // Getters and Setters
    public String getInkColor() {
        return inkColor;
    }

    public void setInkColor(String inkColor) {
        this.inkColor = inkColor;
    }

    public double getTipSize() {
        return tipSize;
    }

    public void setTipSize(double tipSize) {
        this.tipSize = tipSize;
    }

    // Calculate value based on ink color and tip size
    @Override
    public double calculateValue() {
        double value = getPrice() * getQuantity(); ; // Start with base price multiplied by quantity

        // Add premium for gold ink
        if ("Gold".equalsIgnoreCase(inkColor)) {
            value += 5.0 * getQuantity();
        }

        // Add premium for larger tip sizes
        if (tipSize > 1.0) {
            value += 2.0 * getQuantity();
        }

        return value; // Return the final value
    }

    // Implement Categorizable methods
    @Override
    public void setCategory(Category category) {
        super.setCategory(category.getName());
    }

    @Override
    public String getCategory() {
        return super.getCategory(); // Return the category as a String
    }

    // New method to return Category object
    public Category getCategoryObject() {
        return new Category(1L, super.getCategory()); // Convert String to Category
    }
}
