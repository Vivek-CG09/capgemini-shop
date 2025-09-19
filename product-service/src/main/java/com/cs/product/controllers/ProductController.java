package com.cs.product.controllers;

import com.cs.product.entities.Product;
import com.cs.product.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> update(@PathVariable Long productId, @RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.update(productId, product));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> findById(@PathVariable Long productId) {
        return ResponseEntity.ok(productService.findById(productId));
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @DeleteMapping("/{productId}")
    public void deleteById(@PathVariable Long productId) {
        productService.deleteById(productId);
    }
}
