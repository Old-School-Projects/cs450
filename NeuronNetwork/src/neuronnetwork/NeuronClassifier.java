/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuronnetwork;

import java.util.List;
import weka.classifiers.Classifier;
import weka.core.Debug.Random;
import weka.core.Instance;
import weka.core.Instances;

/**
 *
 * @author paul
 */
public class NeuronClassifier extends Classifier{

    @Override
    public void buildClassifier(Instances inst) throws Exception {
        
        int numLayers = 1;
        
        Network network = new Network(numLayers);
        List<Layer> layers = network.getLayers();
        
        
        for (int i = 0; i < layers.size(); i++){
            
            for (int classes = 0; classes < inst.numClasses() + 1; classes++){
                //numClasses = the number of neurons
                Neuron neuron = new Neuron();
                double activation = 0.00;
 
                for (int it = 0; it < inst.numAttributes(); it++){
                    NeuronValue nv = new NeuronValue();
                    nv.setValue(1); // I'm not quite sure how to do this
                    
                    
                    // create random number close to 0 and set weight
                    double rand = getRandomNum();
                    nv.setWeight(rand);
                    
                    activation += nv.getValue() * nv.getWeight();
                    
                    neuron.getInputs().add(nv);
                }
                
                if (activation > 0){
                    NeuronValue nv = new NeuronValue(1);
                    neuron.setOutput(nv);
                    
                    System.out.println(nv.getValue());
                } else {
                    NeuronValue nv = new NeuronValue(0);
                    neuron.setOutput(nv);
                    
                    System.out.println(nv.getValue());
                }
                
                layers.get(i).getNeurons().add(neuron);
                
            } 
            
            
              
            
        }
        
        
        
        
        
        
    }
    
    @Override
    public double classifyInstance(Instance instance){
        
        
        

        return 0;
    }
    
    /**
     * get a random number between -1 and 1
     * @return 
     */
    public double getRandomNum(){
        
        Random rand = new Random();
        double randNum = rand.nextDouble();
        double newRandNum = (randNum * 2) - 1;
        
        return newRandNum;
    }
    
}
