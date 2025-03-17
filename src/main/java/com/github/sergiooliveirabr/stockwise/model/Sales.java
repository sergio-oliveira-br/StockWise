package com.github.sergiooliveirabr.stockwise.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
//@Data
@Table(name = "sales")
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Products products;

    private int qty;

    @ManyToOne
    @JoinColumn(name = "sazonalidadeId")
    private Seasonality seasonality;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Seasonality getSeasonality() {
        return seasonality;
    }

    public void setSeasonality(Seasonality seasonality) {
        this.seasonality = seasonality;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "id=" + id +
                ", products=" + products +
                ", qty=" + qty +
                ", seasonality=" + seasonality +
                '}';
    }
}
