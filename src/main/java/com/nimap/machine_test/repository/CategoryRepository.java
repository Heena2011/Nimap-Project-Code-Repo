package com.nimap.machine_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nimap.machine_test.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>
{
}