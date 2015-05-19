/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id3;

import java.util.ArrayList;
import weka.classifiers.Classifier;
import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;

/**
 *
 * @author paul
 */
public class TreeClassifier extends Classifier{
    Node node = new Node();
    
    
    @Override
    public void buildClassifier(Instances instances) throws Exception {
        ArrayList<Attribute>attributelist = new ArrayList<>();
        //System.out.println(instances.numAttributes());
        
        // get all the attributes
        for (int i = 0; i < instances.numAttributes() - 1; i++){
            attributelist.add(instances.attribute(i));
        }
        
        // put everything in their corresponding bins
//        for (int i = 0; i < instances.numAttributes() - 1; i++){
        
            // go through all the instances for each attribute
        for (int inst = 0; inst < instances.numInstances() - 1; inst++){
            
            if (instances.instance(inst).value(0) < 1){
                node.bin_0.add(instances.instance(inst));
            }
            
            if (instances.instance(inst).value(0) >= 1 && instances.instance(inst).value(0) < 3){
                node.bin_1.add(instances.instance(inst));
            }
            
            if (instances.instance(inst).value(0) >= 3 && instances.instance(inst).value(0) < 5){
                node.bin_2.add(instances.instance(inst));
            }
            
            if (instances.instance(inst).value(0) >= 5){
                node.bin_3.add(instances.instance(inst));
            }
            
            
            
        
        } // attributes for loop
        
        
        double value = calcEntropy();
        System.out.println("STOP");
        
    }
    
    @Override
    public double classifyInstance(Instance instance){
        
        return 0;
    }
    
    /**
     * CALCULATE THE ENTROPY
     */
    public double calcEntropy(){

        int num_0 = 0;
        int num_1 = 0;
        int num_2 = 0;
        int num_3 = 0;
        
        // count the classes in each bin
        for (Instance inst : node.bin_0){
            if (inst.classValue() == 0){
                num_0++;
            } else if (inst.classValue() == 1){
                num_1++;
            } else if (inst.classValue() == 2){
                num_2++;
            } else if (inst.classValue() == 3){
                num_3++;
            }
        }
        
        for (Instance inst : node.bin_1){
            if (inst.classValue() == 0){
                num_0++;
            } else if (inst.classValue() == 1){
                num_1++;
            } else if (inst.classValue() == 2){
                num_2++;
            } else if (inst.classValue() == 3){
                num_3++;
            }
        }
        
        for (Instance inst : node.bin_2){
            if (inst.classValue() == 0){
                num_0++;
            } else if (inst.classValue() == 1){
                num_1++;
            } else if (inst.classValue() == 2){
                num_2++;
            } else if (inst.classValue() == 3){
                num_3++;
            }
        }
        
        for (Instance inst : node.bin_3){
            if (inst.classValue() == 0){
                num_0++;
            } else if (inst.classValue() == 1){
                num_1++;
            } else if (inst.classValue() == 2){
                num_2++;
            } else if (inst.classValue() == 3){
                num_3++;
            }
        }
        
        
        int total = num_0 + num_1 + num_2 + num_3;
        
        double value0 = (num_0/total) * calcLog(num_0/total) * (-1);
        double value1 = (num_1/total) * calcLog(num_1/total);
        double value2 = ((num_2/total) * calcLog(num_2/total));
        double value3 = (num_3/total) * calcLog(num_3/total);
        
        double entropy = value0 - value1 - value2 - value3;
        
        
        System.out.println("STOP");
        
        return entropy;
    }
    
    public void someFunction(){
        
           
    }
    
    /**
     * CALC LOG
     * @param num
     * @return 
     */
    public double calcLog(double num){
        
        double nl1 = Math.log1p(num);
        double nl2 = Math.log1p(2);
        
        return (nl1 / nl2);
    }
    
    
}
