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

    private int numLayers;
    
    
    
    public NeuronClassifier(int nl){
        numLayers = nl;
    }
    
    @Override
    public void buildClassifier(Instances inst) throws Exception {
        
        
        Network network = new Network(numLayers);
        List<Layer> layers = network.getLayers();
        
        System.out.println("Layers size: " + layers.size());
        
        for (int layer = 0; layer < layers.size() - 1; layer++){
            // This is to control the number of neurons per layer
            int numNeurons = 0;
            
            if (layer == 0) {numNeurons = inst.numClasses();}
            else if (layer == 1) {numNeurons = 2;}
            else {numNeurons = inst.numClasses();}
            
            System.out.println("Number of Neurons: " + numNeurons);
            
            for (int classes = 0; classes < numNeurons + 1; classes++){
                //numClasses == the number of neurons
                Neuron neuron = new Neuron();
                double activation = 0.00;
 
                // This is where back propagation didn't work
                for (int it = 0; it < inst.numAttributes(); it++){
                    NeuronValue nv = new NeuronValue();
                    if (layer > 0) {
                        nv.setValue(activation);
                        neuron.setOutput(layers.get(layer-1).getNeurons().get(classes).getOutput());
                    }
                    else{
                        nv.setValue(1); // I can't figure out how to get the values of each instance
                    }
                    // create random number close to 0 and set weight
                    double rand = getRandomNum();
                    nv.setWeight(rand);
                    
                    activation += nv.getValue() * nv.getWeight();
                    
                    neuron.getInputs().add(nv);
                    
                }
                
                double newOutput = calcSigmoid(activation);
                
                NeuronValue nv = new NeuronValue(newOutput);
                
                neuron.setOutput(nv);
                
//                if (activation > 0){
//                    NeuronValue nv = new NeuronValue(1);
//                    neuron.setOutput(nv);
//                    
//                    System.out.println(nv.getValue());
//                } else {
//                    NeuronValue nv = new NeuronValue(0);
//                    neuron.setOutput(nv);
//                    
//                    System.out.println(nv.getValue());
//                }
                
                layers.get(layer).getNeurons().add(neuron);
                
            } 
               
            
        }
        
        System.out.println("I'm done!");
          
    }
    
    @Override
    public double classifyInstance(Instance instance){
        
//        System.out.println("Classify!!!");

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
    
    /**
     * CALCULATE SIGMOID FUNCTION
     * @param h
     * @return 
     */
    public double calcSigmoid(double h){
        
        double value = (1/(1+ Math.pow(Math.E, (-1)*h)));
        
        return value;
    }
    
}
