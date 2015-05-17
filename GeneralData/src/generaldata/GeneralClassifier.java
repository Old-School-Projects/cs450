/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generaldata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static javafx.scene.input.KeyCode.T;

import weka.classifiers.Classifier;
import weka.core.Instance;
import weka.core.Instances;

/**
 *
 * @author paul
 */
public class GeneralClassifier extends Classifier{

    public Instances data;
    private static int k;
    
    public GeneralClassifier(int numNeighbors){
        k = numNeighbors;
    }
    
    @Override
    public void buildClassifier(Instances trainingset) throws Exception {
         
        this.data = trainingset; 
    }
    
    @Override
    public double classifyInstance(Instance instance){
        Instance tempInstance = null;
        int sum = 0;
        double classValue = 0.00;
        ArrayList<Instance> nnList = new ArrayList();
        ArrayList<Integer> indexList = new ArrayList();
        ArrayList<Instance> instanceList = new ArrayList();
        ArrayList<Integer> distanceList = new ArrayList();
        
        // store all the instances in a list
        for (int inst = 0; inst < data.numInstances() - 1; inst++){
            instanceList.add(data.instance(inst));
        }
        
        // * calculate distance going through all the data and doing the 
        // distance formula with each instance compared with the passed
        // through instance
        for (int i = 0; i < data.numInstances() - 1; i++){
            
            tempInstance = data.instance(i);
            for (int it = 0; it < tempInstance.numAttributes() - 1; it++) {         
                sum += Math.abs(instance.value(it) - tempInstance.value(it)); 
            }  
            
            distanceList.add(sum);
            sum = 0;
        }
        
        indexList = getLowestKValuesinList(distanceList, k);
        
        // get the instances that are the NN's by their indexes
        for (int i : indexList) {
            nnList.add(instanceList.get(i));
        }
        
        // 
        List<Double> classValueList = new ArrayList<Double>();
        for (Instance a : nnList){
            classValueList.add(a.classValue());
        }
        
        // find the majority of same class
        classValue = CalculateMaximum(classValueList);
        
        
        return classValue;
    }
    
    /**
     * GET LOWEST VALUE IN LIST
     * @param list
     * @return lowestValueIndex
     */
    private ArrayList getLowestKValuesinList(ArrayList list, int k){
        
        ArrayList lowestValuesIndexes = new ArrayList<>();
        int counter = 0;
        ArrayList tempList = new ArrayList<>();
        
        // create a copy of the list passed in
        for (int o = 0; o < list.size() - 1; o++){
            tempList.add(list.get(o));
        }
         
        // sort one to get lowest value
        Collections.sort(list);
        

        for (int i  = 0; i < list.size() - 1; i++){
            if (counter > (k - 1)){
                break;
            }
               
            if ((Integer)list.get(counter) == (Integer)tempList.get(i)) {
               lowestValuesIndexes.add(i);
               counter++;
            }
        }
        return lowestValuesIndexes;
        
    }

    /**
     * FIND MAX
     * @param array
     * @return 
     */
    public static double CalculateMaximum(List array)
    {
        double maximum = (double) array.get(0);
        for (int i = 1; i < array.size(); i++)
        {
            if ( (double) array.get(i) > maximum)
            {
            maximum = (double) array.get(i);
            }
        }
        return maximum;
    }   
    
}
