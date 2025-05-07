package org.example.inventorymanagement.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.inventorymanagement.model.InventoryManagerClass;
import org.example.inventorymanagement.model.Product;

import java.io.IOException;
import java.util.List;

@WebServlet("/inventory") // Map this servlet to the URL pattern "/inventory"
public class InventoryServlet extends HttpServlet {
    private InventoryManagerClass inventoryManager;

    @Override
    public void init() throws ServletException {
        // Initialize the inventory manager with sample data
        inventoryManager = new InventoryManagerClass();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String categoryId = request.getParameter("id");

        if ("category".equals(action) && categoryId != null) {
            // Filter products by category
            List<Product> filteredProducts = inventoryManager.filterProductsByCategory(categoryId);
            request.setAttribute("products", filteredProducts);
            request.setAttribute("selectedCategoryId", categoryId);
        } else {
            // Retrieve all products
            request.setAttribute("products", inventoryManager.getAllProducts());
        }

        // Retrieve all categories to display in the filter
        request.setAttribute("categories", inventoryManager.getAllCategories());

        // Forward to the inventory JSP
        request.getRequestDispatcher("/inventory-list.jsp").forward(request, response);
    }
}
