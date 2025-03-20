package com.github.sergiooliveirabr.stockwise.service;

import com.github.sergiooliveirabr.stockwise.model.Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import weka.classifiers.trees.M5P;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

import java.util.List;

@Service
public class WekaService {

    private RegressionModelTrainer regressionModelTrainer;
    private DataPreprocessor dataPreprocessor;

    @Autowired
    public WekaService(RegressionModelTrainer regressionModelTrainer,
                       DataPreprocessor dataPreprocessor ) {

        this.regressionModelTrainer = regressionModelTrainer;
        this.dataPreprocessor = dataPreprocessor;
    }

    public void generateArffFile(List<Sales> trainSales) throws Exception {
        Instances trainingData = regressionModelTrainer.createInstances(trainSales, dataPreprocessor);
        ConverterUtils.DataSink.write("sales_data.arff", trainingData);
    }
}
