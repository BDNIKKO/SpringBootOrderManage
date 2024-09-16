package org.example.springbootordermanage.service;

import org.example.springbootordermanage.model.CustomerOrder;
import org.example.springbootordermanage.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public CustomerOrder createOrder(CustomerOrder customerOrder) {
        return orderRepository.save(customerOrder);
    }

    public CustomerOrder getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public CustomerOrder updateOrder(Long id, CustomerOrder customerOrder) {
        CustomerOrder existingCustomerOrder = getOrderById(id);
        if (existingCustomerOrder != null) {
            existingCustomerOrder.setCustomerName(customerOrder.getCustomerName());
            // Add more fields to update as needed
            return orderRepository.save(existingCustomerOrder);
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
