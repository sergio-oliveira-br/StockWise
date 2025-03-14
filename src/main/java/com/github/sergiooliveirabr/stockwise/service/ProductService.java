package com.github.sergiooliveirabr.stockwise.service;

import com.github.sergiooliveirabr.stockwise.model.Products;
import com.github.sergiooliveirabr.stockwise.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

    public Iterable<Products> findAll() {
        return productRepository.findAll();
    }
}
