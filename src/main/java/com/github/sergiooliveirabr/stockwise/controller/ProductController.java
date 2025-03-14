package com.github.sergiooliveirabr.stockwise.controller;

import com.github.sergiooliveirabr.stockwise.model.Products;
import com.github.sergiooliveirabr.stockwise.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller()
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/save")
    public String createProduct(@ModelAttribute Products product) {

        productService.saveProduct(product);
        return "redirect:/products/all";
    }

    @GetMapping("/all")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.findAll());
        return "index";
    }
}
