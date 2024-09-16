package org.example.springbootordermanage.repository;

import org.example.springbootordermanage.model.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<CustomerOrder, Long> {
}
