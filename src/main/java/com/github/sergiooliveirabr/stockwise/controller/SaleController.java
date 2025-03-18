package com.github.sergiooliveirabr.stockwise.controller;

import com.github.sergiooliveirabr.stockwise.model.Products;
import com.github.sergiooliveirabr.stockwise.model.Sales;
import com.github.sergiooliveirabr.stockwise.service.ProductService;
import com.github.sergiooliveirabr.stockwise.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/sales")
public class SaleController {

    private final SaleService saleService;
    private final ProductService productService;

    @Autowired
    public SaleController(SaleService saleService, ProductService productService) {
        this.saleService = saleService;
        this.productService = productService;
    }

    @PostMapping("/save")
    public String createSales(@ModelAttribute Sales sale, @RequestParam (name = "productId")Long productId) {

        Optional<Products> productOptional = productService.findProductById(productId);

        if (productOptional.isPresent()) {
            sale.setProducts(productOptional.get());
            saleService.saveSales(sale);
            return "redirect:/";
        }else {
            return "redirect:/sales/all?error=productNotFound";
        }
    }

    @GetMapping("/all")
    public String getAllSales(Model model) {

        model.addAttribute("sales", saleService.findAllSales());
        return "index";
    }
}
