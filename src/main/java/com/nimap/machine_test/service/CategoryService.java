package com.nimap.machine_test.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nimap.machine_test.entity.Category;

import com.nimap.machine_test.repository.CategoryRepository;


@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Get all categories with pagination
    public Page<Category> getAllCategories(int page, int size) {
        Pageable pageable = PageRequest.of(page, size); // Pagination with dynamic size
        return categoryRepository.findAll(pageable);
    }

    // Create a new category
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Get category by ID
    public Category getCategoryById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElseThrow(() -> new RuntimeException("Category not found")); // Exception handling for category not found
    }

    // Update category by ID
    public Category updateCategory(Long id, Category category) {
        if (categoryRepository.existsById(id)) {
            category.setId(id);
            return categoryRepository.save(category);
        }
        throw new RuntimeException("Category not found for update"); // Exception if not found
    }

    // Delete category by ID
    public void deleteCategory(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
        } else {
            throw new RuntimeException("Category not found for deletion"); // Handle delete failure
        }
    }
    public List<Category> getAllCategories(int page) {
        Pageable pageable = PageRequest.of(page, 10);  // 10 items per page
        Page<Category> categoriesPage = categoryRepository.findAll(pageable);
        return categoriesPage.getContent();
    }
}