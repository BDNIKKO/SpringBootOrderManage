package org.example.springbootordermanage.service;

import org.example.springbootordermanage.model.CustomerOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CustomerOrderServiceTest {

    @Autowired
    private CustomerOrderService customerOrderService;

    private CustomerOrder order;

    @BeforeEach
    public void setUp() {
        order = new CustomerOrder();
        order.setCustomerName("John Doe");
        customerOrderService.createOrder(order);
    }

    @Test
    void testCreateOrder() {
        CustomerOrder savedOrder = customerOrderService.createOrder(order);
        assertNotNull(savedOrder);
        assertEquals("John Doe", savedOrder.getCustomerName());
    }

    @Test
    void testGetOrderById() {
        CustomerOrder retrievedOrder = customerOrderService.getOrderById(order.getId());
        assertNotNull(retrievedOrder);
        assertEquals(order.getId(), retrievedOrder.getId());
    }

    @Test
    void testUpdateOrder() {
        order.setCustomerName("Jane Doe");
        CustomerOrder updatedOrder = customerOrderService.updateOrder(order.getId(), order);
        assertNotNull(updatedOrder);
        assertEquals("Jane Doe", updatedOrder.getCustomerName());
    }

    @Test
    void testDeleteOrder() {
        customerOrderService.deleteOrder(order.getId());
        CustomerOrder deletedOrder = customerOrderService.getOrderById(order.getId());
        assertNull(deletedOrder);
    }

    @Test
    void testGetAllOrders() {
        assertFalse(customerOrderService.getAllOrders().isEmpty());
    }
}
