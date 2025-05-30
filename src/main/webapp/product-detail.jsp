<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Supply Details - ${product.name}</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f5f5f5;
        }
        h1, h2 {
            color: #333;
        }
        .container {
            background-color: white;
            border-radius: 5px;
            padding: 20px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            max-width: 800px;
            margin: 0 auto;
        }
        .product-details {
            margin-top: 20px;
        }
        .detail-row {
            display: flex;
            padding: 10px 0;
            border-bottom: 1px solid #eee;
        }
        .detail-label {
            width: 30%;
            font-weight: bold;
        }
        .detail-value {
            width: 70%;
        }
        .back-link {
            display: inline-block;
            margin-top: 20px;
            color: #2196F3;
            text-decoration: none;
        }
        .back-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Supply Details</h1>

        <div class="product-details">
            <!-- Common Supply Properties -->
            <div class="detail-row">
                <div class="detail-label">ID:</div>
                <div class="detail-value">${product.id}</div>
            </div>

            <div class="detail-row">
                <div class="detail-label">Name:</div>
                <div class="detail-value">${product.name}</div>
            </div>

            <div class="detail-row">
                <div class="detail-label">Price:</div>
                <div class="detail-value">$${product.price}</div>
            </div>

            <div class="detail-row">
                <div class="detail-label">Category:</div>
                <div class="detail-value">${product.category.name}</div>
            </div>

            <div class="detail-row">
                <div class="detail-label">Quantity:</div>
                <div class="detail-value">${product.quantity}</div>
            </div>
        </div>
        
        <a href="${pageContext.request.contextPath}/inventory" class="back-link">← Back to Inventory List</a>
    </div>
</body>
</html>
