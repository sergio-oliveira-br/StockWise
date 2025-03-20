package com.github.sergiooliveirabr.stockwise.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
//@Data
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
