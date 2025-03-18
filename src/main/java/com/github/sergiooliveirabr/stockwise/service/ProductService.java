package com.github.sergiooliveirabr.stockwise.service;

import com.github.sergiooliveirabr.stockwise.model.Products;
import com.github.sergiooliveirabr.stockwise.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saveProduct(Products products) {
        productRepository.save(products);
    }

    public Iterable<Products> findAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Products> findProductById(Long id) {
        return productRepository.findById(id);
    }
}
