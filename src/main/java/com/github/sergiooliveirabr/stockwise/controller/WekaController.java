package com.github.sergiooliveirabr.stockwise.controller;

import com.github.sergiooliveirabr.stockwise.model.Sales;
import com.github.sergiooliveirabr.stockwise.service.SaleService;
import com.github.sergiooliveirabr.stockwise.service.WekaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/weka")
public class WekaController {

    private WekaService wekaService;
    private SaleService saleService;


    @Autowired
    public WekaController(WekaService wekaService, SaleService saleService) {
        this.wekaService = wekaService;
        this.saleService = saleService;
    }

    @GetMapping("/generateArff")
    public String generateArff(Model model) throws Exception {

        List<Sales> salesList = saleService.findAllSales();
        wekaService.generateArffFile(salesList);

        model.addAttribute("message", "ARFF file generated successfully!");
        return "ARFF file generated!";
    }
}
