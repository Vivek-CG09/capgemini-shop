package com.cs.product.services;

import com.cs.product.entities.Product;

import java.util.List;

public interface ProductService {

    Product save(Product product);

    Product update(Long productId, Product product);

    List<Product> findAll();

    Product findById(Long productId);

    void deleteById(Long productId);
}
