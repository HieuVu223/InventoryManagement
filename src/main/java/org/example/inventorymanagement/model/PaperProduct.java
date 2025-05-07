package org.example.inventorymanagement.model;

public class PaperProduct extends Product implements Categorizable  {
    private int sheetCount;  // Number of sheets in the product
    private String paperSize; // Size of the paper (e.g., A4, Letter)

    // Constructor
    public PaperProduct(Long id, String name, double price, String category, int quantity, int sheetCount, String paperSize) {
        super(id, name, price, category, quantity);
        this.sheetCount = sheetCount;
        this.paperSize = paperSize;
    }
    // Getters and Setters
    public int getSheetCount() {
        return sheetCount;
    }

    public void setSheetCount(int sheetCount) {
        this.sheetCount = sheetCount;
    }

    public String getPaperSize() {
        return paperSize;
    }

    public void setPaperSize(String paperSize) {
        this.paperSize = paperSize;
    }

    @Override
    public double calculateValue() {
        return getPrice() * getQuantity(); // Just return the base price
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
