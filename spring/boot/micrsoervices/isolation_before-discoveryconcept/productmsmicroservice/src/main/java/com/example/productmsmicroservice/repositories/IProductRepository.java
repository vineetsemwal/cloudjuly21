package com.example.productmsmicroservice.repositories;

import com.example.productmsmicroservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
}
