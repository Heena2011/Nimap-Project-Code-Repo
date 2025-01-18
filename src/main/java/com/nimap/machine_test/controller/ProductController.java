package com.nimap.machine_test.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.machine_test.entity.Product;
import com.nimap.machine_test.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	 @Autowired
	    private ProductService productService;

	    // Get all products with pagination
	    @GetMapping
	    public Page<Product> getProducts(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
	        return productService.getAllProducts(page, size); // Apply pagination
	    }

	    // Create a new product
	    @PostMapping
	    public Product createProduct(@RequestBody Product product) {
	        return productService.createProduct(product);
	    }

	    // Get product by ID
	    @GetMapping("/{id}")
	    public Product getProductById(@PathVariable Long id) {
	        return productService.getProductById(id);
	    }

	    // Update product by ID
	    @PutMapping("/{id}")
	    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
	        return productService.updateProduct(id, product);
	    }

	    // Delete product by ID
	    @DeleteMapping("/{id}")
	    public void deleteProduct(@PathVariable Long id) {
	        productService.deleteProduct(id);
	    }
}