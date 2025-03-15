package com.github.sergiooliveirabr.stockwise.controller;

import com.github.sergiooliveirabr.stockwise.service.ProductService;
import com.github.sergiooliveirabr.stockwise.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    private final ProductService productService;
    private final SaleService saleService;

    @Autowired
    public IndexController(ProductService productService, SaleService saleService) {
        this.productService = productService;
        this.saleService = saleService;
    }

    @GetMapping
    public String index(Model model) {

        System.out.println("Rota raiz acessada!");

        model.addAttribute("products", productService.findAll());
        model.addAttribute("sales", saleService.findAll());
        return "index";
    }

}
