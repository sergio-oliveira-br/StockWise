package com.github.sergiooliveirabr.stockwise.repository;

import com.github.sergiooliveirabr.stockwise.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<Sales, Long> {
}
