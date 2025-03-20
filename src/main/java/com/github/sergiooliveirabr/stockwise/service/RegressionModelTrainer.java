package com.github.sergiooliveirabr.stockwise.service;

import com.github.sergiooliveirabr.stockwise.model.Sales;
import org.springframework.stereotype.Service;
import weka.classifiers.trees.M5P;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegressionModelTrainer {

    public Instances createInstances(List<Sales> trainSales, DataPreprocessor dataPreprocessor) throws Exception {

        ArrayList<Attribute> attributes = new ArrayList<>();

        attributes.add(new Attribute("seasonality"));
        attributes.add(new Attribute("qty"));


        Instances trainingData = new Instances("SalesTraining", attributes, trainSales.size());
        trainingData.setClassIndex(1);

        for (Sales sale : trainSales) {
            double[] features = dataPreprocessor.extractFeatures(List.of(sale))[0];
            double[] instanceValues = {features[0], features[1]};
            trainingData.add(new DenseInstance(1.0, instanceValues));
        }
        return trainingData;
    }
}
