/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package neuronnetwork;

/**
 *
 * @author paul
 */
public class NeuronValue {
    private double value;
    private double weight;
    
    public NeuronValue(){
        value = 0.00;
    }
    
    public NeuronValue(double value){
        this.value = value;
    }
    
    public double getWeight(){
        return weight;
    }
    
    public void setWeight(double weight){
        this.weight = weight;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
    
}
