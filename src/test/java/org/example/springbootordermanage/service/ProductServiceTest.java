package org.example.springbootordermanage.service;

import org.example.springbootordermanage.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    private Product product;

    @BeforeEach
    public void setUp() {
        product = new Product();
        product.setName("Phone");
        product.setPrice(800.00);
        productService.createProduct(product);
    }

    @Test
    void testCreateProduct() {
        Product savedProduct = productService.createProduct(product);
        assertNotNull(savedProduct);
        assertEquals("Phone", savedProduct.getName());
        assertEquals(800.00, savedProduct.getPrice());
    }

    @Test
    void testGetProductById() {
        Product retrievedProduct = productService.getProductById(product.getId());
        assertNotNull(retrievedProduct);
        assertEquals(product.getId(), retrievedProduct.getId());
    }

    @Test
    void testUpdateProduct() {
        product.setName("Tablet");
        product.setPrice(500.00);
        Product updatedProduct = productService.updateProduct(product.getId(), product);
        assertNotNull(updatedProduct);
        assertEquals("Tablet", updatedProduct.getName());
    }

    @Test
    void testDeleteProduct() {
        productService.deleteProduct(product.getId());
        Product deletedProduct = productService.getProductById(product.getId());
        assertNull(deletedProduct);
    }

    @Test
    void testGetAllProducts() {
        List<Product> products = productService.getAllProducts();
        assertNotNull(products);
        assertFalse(products.isEmpty());
    }
}
