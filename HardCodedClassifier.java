package irisdata;

import weka.classifiers.Evaluation;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author paul
 */
public class IrisData {

    public static void main(String[] args) throws Exception {
        
    String file = "/Users/paul/Desktop/BYU-Idaho/Spring2015/CS450/iris.csv";
        
    DataSource source = new DataSource(file);
    Instances data = source.getDataSet();

    // we are looking for the last attribute
    if (data.classIndex() == -1){
        data.setClassIndex(data.numAttributes() - 1);
    }
        
    
    data.randomize(new Random(1));
    
    // set training set to 70%
    RemovePercentage remove = new RemovePercentage();
    remove.setPercentage(30);
    remove.setInputFormat(data);
    Instances trainingSet = Filter.useFilter(data, remove);
    
    // set the rest for the testing set
    remove.setInvertSelection(true);
    Instances testSet = Filter.useFilter(data, remove);
    
    
    HardCodedClassifier classifier = new HardCodedClassifier();
    classifier.buildClassifier(trainingSet);
        
        
    Evaluation eval = new Evaluation(trainingSet);
    eval.evaluateModel(classifier, testSet);
    //eval.crossValidateModel(classifier, data, 10, new Random(1));
        
    System.out.println("Results: " + eval.toSummaryString());   
    
    }
    
}

