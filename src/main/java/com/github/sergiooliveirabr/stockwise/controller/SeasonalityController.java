package com.github.sergiooliveirabr.stockwise.controller;

import com.github.sergiooliveirabr.stockwise.model.Seasonality;
import com.github.sergiooliveirabr.stockwise.service.SeasonalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/seasonality")
public class SeasonalityController {

    private final SeasonalityService seasonalityService;

    @Autowired
    public SeasonalityController(SeasonalityService seasonalityService) {
        this.seasonalityService = seasonalityService;
    }

    @PostMapping("/save")
    public String createSeasonality(@ModelAttribute Seasonality seasonality) {
        seasonalityService.saveSeasonality(seasonality);
        return "redirect:/";
    }

    @GetMapping("/all")
    public String getAllSeasonalities(Model model) {
        model.addAttribute("seasonalities", seasonalityService.findAllSeasonalities());
        return "index";
    }
}
