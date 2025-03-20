package com.github.sergiooliveirabr.stockwise.service;

import com.github.sergiooliveirabr.stockwise.model.Sales;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataPreprocessor {

    public double [][] extractFeatures(List<Sales> features) {

        double[][] featuresMatrix = new double[features.size()][2];

        for (int i = 0; i < features.size(); i++) {
            featuresMatrix[i][0] = features.get(i).getSeasonality().getId();
            featuresMatrix[i][1] = features.get(i).getQty();
        }
        return featuresMatrix;
    }
}
