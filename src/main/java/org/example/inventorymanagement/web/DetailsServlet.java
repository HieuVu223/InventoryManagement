package org.example.inventorymanagement.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.inventorymanagement.model.InventoryManagerClass;
import org.example.inventorymanagement.model.Product;

import java.io.IOException;

@WebServlet("/details") // Map this servlet to the URL pattern "/details"
public class DetailsServlet extends HttpServlet {
    private InventoryManagerClass inventoryManager;

    @Override
    public void init() throws ServletException {
        // Initialize inventory manager with sample data
        inventoryManager = new InventoryManagerClass();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("id");

        if (productId != null) {
            // Find the product by ID
            Product product = inventoryManager.getAllProducts().stream()
                    .filter(p -> p.getId().toString().equals(productId))
                    .findFirst()
                    .orElse(null);

            if (product != null) {
                request.setAttribute("product", product);
                request.getRequestDispatcher("/product-detail.jsp").forward(request, response);
                return;
            }

            // Redirect to inventory page if product not found
            response.sendRedirect(request.getContextPath() + "/inventory");
        }
    }
}