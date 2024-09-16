package org.example.springbootordermanage.repository;

import org.example.springbootordermanage.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
