package org.example.springbootordermanage;

import org.example.springbootordermanage.model.Product;
import org.example.springbootordermanage.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @org.junit.Test
    @Test
    public void testCreateProduct() {
        // Make sure Product has a constructor that takes name and price
        Product product = new Product("Phone", 800.00);

        // Create a product and check if it's saved correctly
        Product savedProduct = productService.createProduct(product);
        assertNotNull(savedProduct);
        assertEquals("Phone", savedProduct.getName());
    }

    @Test
    public void testGetProductById() {
        // Assuming that a product with ID 1 exists in the database
        Product product = productService.getProductById(1L);
        assertNotNull(product);
        assertEquals(1L, product.getId());
    }

    @Test
    public void testUpdateProduct() {
        // Assuming a product with ID 1 already exists
        Product product = new Product("Tablet", 500.00);

        // Update the product with ID 1
        Product updatedProduct = productService.updateProduct(1L, product);
        assertEquals("Tablet", updatedProduct.getName());
    }

    @Test
    public void testDeleteProduct() {
        // Assuming a product with ID 1 exists and can be deleted
        productService.deleteProduct(1L);
        assertNull(productService.getProductById(1L));
    }

    @Test
    public void testGetAllProducts() {
        // Fetch all products and check if the list is not empty
        List<Product> products = productService.getAllProducts();
        assertNotNull(products);
        assertTrue(products.size() > 0);
    }
}
