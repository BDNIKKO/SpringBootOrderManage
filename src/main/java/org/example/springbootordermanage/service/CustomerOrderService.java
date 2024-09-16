package org.example.springbootordermanage.service;

import org.example.springbootordermanage.model.CustomerOrder;
import org.example.springbootordermanage.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderService {

    private final OrderRepository orderRepository;

    // Constructor injection
    @Autowired
    public CustomerOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public CustomerOrder createOrder(CustomerOrder customerOrder) {
        return orderRepository.save(customerOrder);
    }

    public CustomerOrder getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public CustomerOrder updateOrder(Long id, CustomerOrder customerOrder) {
        CustomerOrder existingOrder = getOrderById(id);
        if (existingOrder != null) {
            existingOrder.setCustomerName(customerOrder.getCustomerName());
            // Add more fields if necessary
            return orderRepository.save(existingOrder);
        }
        return null;
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public List<CustomerOrder> getAllOrders() {
        return orderRepository.findAll();
    }
}
