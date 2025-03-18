package com.github.sergiooliveirabr.stockwise.service;

import com.github.sergiooliveirabr.stockwise.model.Seasonality;
import com.github.sergiooliveirabr.stockwise.repository.SeasonalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SeasonalityService {

    private final SeasonalityRepository seasonalityRepository;

    @Autowired
    public SeasonalityService(SeasonalityRepository seasonalityRepository) {
        this.seasonalityRepository = seasonalityRepository;
    }

    public void saveSeasonality(Seasonality seasonality) {
        seasonalityRepository.save(seasonality);
    }

    public Iterable<Seasonality> findAllSeasonalities() {
        return seasonalityRepository.findAll();
    }

    public Optional<Seasonality> findSeasonalityById(Long id) {
        return seasonalityRepository.findById(id);
    }
}
