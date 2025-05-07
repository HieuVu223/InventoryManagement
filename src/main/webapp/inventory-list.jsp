<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Office Supplies Inventory</title>
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
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
            font-weight: bold;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
        .category-filter {
            margin-bottom: 20px;
        }
        .category-filter a {
            margin-right: 10px;
            text-decoration: none;
            padding: 5px 10px;
            border-radius: 3px;
            background-color: #eee;
            color: #333;
        }
        .category-filter a.selected {
            background-color: #4CAF50;
            color: white;
        }
        .view-link {
            color: #2196F3;
            text-decoration: none;
        }
        .view-link:hover {
            text-decoration: underline;
        }
        .add-form {
            margin-top: 30px;
            border-top: 1px solid #ddd;
            padding-top: 20px;
        }
        .form-row {
            margin-bottom: 15px;
        }
        label {
            display: inline-block;
            width: 150px;
            font-weight: bold;
        }
        input[type="text"], input[type="number"], select {
            width: 250px;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        button {
            padding: 10px 15px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #45a049;
        }
        .message {
            padding: 10px;
            margin-bottom: 20px;
            border-radius: 4px;
        }
        .success {
            background-color: #d4edda;
            color: #155724;
            border: 1px solid #c3e6cb;
        }
        .error {
            background-color: #f8d7da;
            color: #721c24;
            border: 1px solid #f5c6cb;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Office Supplies Inventory</h1>

        <!-- Display messages if any -->
        <c:if test="${not empty successMessage}">
            <div class="message success">${successMessage}</div>
        </c:if>
        <c:if test="${not empty errorMessage}">
            <div class="message error">${errorMessage}</div>
        </c:if>

        <!-- Category filter -->
        <div class="category-filter">
            <strong>Filter by Category:</strong>
            <a href="${pageContext.request.contextPath}/inventory"
               class="${empty selectedCategoryId ? 'selected' : ''}">All Supplies</a>

            <c:forEach var="category" items="${categories}">
                <a href="${pageContext.request.contextPath}/inventory?action=category&id=${category.id}"
                   class="${selectedCategoryId == category.id ? 'selected' : ''}">${category.name}</a>
            </c:forEach>
        </div>

        <!-- Product table -->
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Category</th>
                    <th>Price</th>
                    <th>Stock</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:choose>
                    <c:when test="${empty products}">
                        <tr>
                            <td colspan="6">No supplies found</td>
                        </tr>
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="product" items="${products}">
                            <tr>
                                <td>${product.id}</td>
                                <td>${product.name}</td>
                                <td>${product.category.name}</td>
                                <td>$${product.price}</td>
                                <td>${product.quantity}</td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/inventory?action=view&id=${product.id}"
                                       class="view-link">View Details</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </tbody>
        </table>
    </div>
</body>
</html>
