package irisdata;

import weka.classifiers.Evaluation;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author paul
 */
public class IrisData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        String file = "/Users/paul/Desktop/BYU-Idaho/Spring2015/CS450/iris.csv";
        
         DataSource source = new DataSource(file);
        Instances data = source.getDataSet();

    if (data.classIndex() == -1){
        data.setClassIndex(data.numAttributes() - 1);
    }
        
    
    HardCodedClassifier classifier = new HardCodedClassifier();
        classifier.buildClassifier(data);
        
        Evaluation eval = new Evaluation(data);
        
    }
    
    
    
    
    
}

