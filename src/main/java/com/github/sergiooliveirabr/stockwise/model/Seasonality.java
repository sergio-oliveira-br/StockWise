package com.github.sergiooliveirabr.stockwise.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
//@Data
@Table(name = "seasonality")
public class Seasonality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypeOfSeasonality typeOfSeasonality;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeOfSeasonality getTypeOfSeasonality() {
        return typeOfSeasonality;
    }

    public void setTypeOfSeasonality(TypeOfSeasonality typeOfSeasonality) {
        this.typeOfSeasonality = typeOfSeasonality;
    }

    @Override
    public String toString() {
        return "Seasonality{" +
                "id=" + id +
                ", typeOfSeasonality=" + typeOfSeasonality +
                '}';
    }
}
