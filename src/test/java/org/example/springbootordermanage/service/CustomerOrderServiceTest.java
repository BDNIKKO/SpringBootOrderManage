package org.example.springbootordermanage.service;

import org.example.springbootordermanage.model.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void testCreateOrder() {
        Order order = new Order();
        order.setCustomerName("John Doe");

        Order savedOrder = orderService.createOrder(order);
        assertNotNull(savedOrder);
        assertEquals("John Doe", savedOrder.getCustomerName());
    }

    @Test
    public void testGetOrderById() {
        Order order = orderService.getOrderById(1L); // Ensure there is an order with ID 1L in your database
        assertNotNull(order);
        assertEquals(1L, order.getId());
    }

    @Test
    public void testUpdateOrder() {
        Order order = new Order();
        order.setCustomerName("Jane Doe");

        Order updatedOrder = orderService.updateOrder(1L, order);
        assertEquals("Jane Doe", updatedOrder.getCustomerName());
    }

    @Test
    public void testDeleteOrder() {
        orderService.deleteOrder(1L); // Ensure there is an order with ID 1L
        assertNull(orderService.getOrderById(1L));
    }

    @Test
    public void testGetAllOrders() {
        assertTrue(orderService.getAllOrders().size() > 0);
    }
}
