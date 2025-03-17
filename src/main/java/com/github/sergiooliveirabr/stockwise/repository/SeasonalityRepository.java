package com.github.sergiooliveirabr.stockwise.repository;

import com.github.sergiooliveirabr.stockwise.model.Seasonality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonalityRepository extends JpaRepository<Seasonality, Long> {
}
