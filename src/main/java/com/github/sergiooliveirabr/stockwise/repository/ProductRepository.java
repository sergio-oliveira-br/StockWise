package com.github.sergiooliveirabr.stockwise.repository;

import com.github.sergiooliveirabr.stockwise.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Long> {

}
