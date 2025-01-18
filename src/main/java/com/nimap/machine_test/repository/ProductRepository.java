package com.nimap.machine_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nimap.machine_test.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
