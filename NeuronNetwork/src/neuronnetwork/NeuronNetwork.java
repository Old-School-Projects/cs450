/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuronnetwork;

import weka.classifiers.Evaluation;
import weka.core.Debug;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;
import weka.filters.Filter;
import weka.filters.unsupervised.instance.RemovePercentage;

/**
 *
 * @author paul
 */
public class NeuronNetwork {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
    //String file = "/Users/paul/Desktop/BYU-Idaho/Spring2015/CS450/iris.csv";
    String file = "/Users/paul/Desktop/BYU-Idaho/Spring2015/CS450/pima-indians-diabetes.csv";
    
        
    ConverterUtils.DataSource source = new ConverterUtils.DataSource(file);
    Instances data = source.getDataSet();
        
    if (data.classIndex() == -1){
        data.setClassIndex(data.numAttributes() - 1);
    }
    
    data.randomize(new Debug.Random(1));
    
    // set training set to 70%
    RemovePercentage remove = new RemovePercentage();
    remove.setPercentage(30);
    remove.setInputFormat(data);
    Instances trainingSet = Filter.useFilter(data, remove);
    
    // set the rest for the testing set
    remove.setInvertSelection(true);
    Instances testSet = Filter.useFilter(data, remove);
    
    // train classifier
    NeuronClassifier classifier = new NeuronClassifier(3);
    classifier.buildClassifier(trainingSet); 
        
    // Evaluate classifier
    Evaluation eval = new Evaluation(trainingSet);
    eval.evaluateModel(classifier, testSet);
    
    // Print some statistics
    System.out.println("Results: " + eval.toSummaryString());
    
    }
    
}
