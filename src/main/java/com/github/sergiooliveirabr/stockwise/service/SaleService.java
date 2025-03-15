package com.github.sergiooliveirabr.stockwise.service;

import com.github.sergiooliveirabr.stockwise.model.Sales;
import com.github.sergiooliveirabr.stockwise.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {

    private final SalesRepository salesRepository;

    @Autowired
    public SaleService(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    public void saveSales(Sales sales) {
        salesRepository.save(sales);
    }

    public Iterable<Sales> findAll() {
        return salesRepository.findAll();
    }

}
