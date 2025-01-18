package com.nimap.machine_test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nimap.machine_test.entity.Product;
import com.nimap.machine_test.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	// Get all products with pagination
	public Page<Product> getAllProducts(int page, int size) {
		Pageable pageable = PageRequest.of(page, size); // Pagination with dynamic size
		return productRepository.findAll(pageable);
	}

	// Create a new product
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	// Get product by ID
	public Product getProductById(Long id) {
		Optional<Product> product = productRepository.findById(id);
		return product.orElseThrow(() -> new RuntimeException("Product not found")); // Exception handling for product
																						// not found
	}

	// Update product by ID
	public Product updateProduct(Long id, Product product) {
		if (productRepository.existsById(id)) {
			product.setId(id);
			return productRepository.save(product);
		}
		throw new RuntimeException("Product not found for update"); // Exception if not found
	}

	// Delete product by ID
	public void deleteProduct(Long id) {
		if (productRepository.existsById(id)) {
			productRepository.deleteById(id);
		} else {
			throw new RuntimeException("Product not found for deletion"); // Handle delete failure
		}
	}
	public List<Product> getAllProducts(int page) {
	    Pageable pageable = PageRequest.of(page, 10);  // 10 items per page
	    Page<Product> productsPage = productRepository.findAll(pageable);
	    return productsPage.getContent();
	}
}
